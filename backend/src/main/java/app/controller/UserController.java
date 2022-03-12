package app.controller;

import java.io.IOException;
import java.security.Principal;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import app.model.User;
import app.service.CommentService;
import app.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CommentService commentService;
	
	@ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();

		if (principal != null) {
			model.addAttribute("logged", true);
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
		} else {
			model.addAttribute("logged", false);
		}
	}
	
	@GetMapping("/profile/{id}")
	public String profile(Model model, @PathVariable long id) {
		User user = userService.findById(id).orElseThrow();
		model.addAttribute("user", user);
		model.addAttribute("comments", commentService.findByUser(user,  PageRequest.of(0,5)));
		return "profile";
	}
	
	@GetMapping("/{id}/imageProfile")
	public ResponseEntity<Object> downloadImageProfile(@PathVariable long id) throws SQLException {
		Optional<User> user = userService.findById(id);
		
		if (user.isPresent() && user.get().getImageFile() != null) {
			Resource file = new InputStreamResource(user.get().getImageFile().getBinaryStream());
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg").contentLength(user.get().getImageFile().length()).body(file);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/editProfile/{id}")
	public String editProfile(Model model, @PathVariable long id) {
		model.addAttribute("user", userService.findById(id).orElseThrow());
		
		return "editProfile";
	}
	
	@PostMapping("/editProfile")
	public String editProfileProcess(Model model, User newUser, MultipartFile imageField) throws IOException, SQLException {
		User user = userService.findById(newUser.getId()).orElseThrow();
		updateImageProfile(newUser, imageField);
		user.getComments().forEach(c -> newUser.addComment(c));
		userService.save(newUser);
		return "redirect:/profile/" + user.getId();
	}

	@GetMapping("/editPassword/{id}")
	public String editPassword(Model model, @PathVariable long id){
		model.addAttribute("user", userService.findById(id).orElseThrow());
		return "editPassword";
	}

	@PostMapping("/editPassword")
	public String editPasswordProcess(Model model, @RequestParam long id, @RequestParam String oldPassword, @RequestParam String newPassword) throws IOException, SQLException {
		User user = userService.findById(id).orElseThrow(); 
		
		if (passwordEncoder.matches(oldPassword, user.getEncodedPassword())){
			user.setEncodedPassword(passwordEncoder.encode(newPassword));
			userService.save(user);
			return "redirect:/profile/" + user.getId();
		}
		
		return "redirect:/errorOldPassword/" + user.getId();
	}
	
	@GetMapping("/errorOldPassword/{id}")
	public String errorOldPassword(Model model, @PathVariable long id) {
		model.addAttribute("id", id);
		return "errorOldPassword";
	}
	
	@GetMapping("/followers/{id}")
	public String followers(Model model, @PathVariable long id) {
		User user = userService.findById(id).orElseThrow();
		model.addAttribute("user", user);
		return "followers";
	}
	
	@GetMapping("/following/{id}")
	public String following(Model model, @PathVariable long id) {
		User user = userService.findById(id).orElseThrow();
		model.addAttribute("user", user);
		return "following";
	}
	
	@GetMapping("/watchProfile/{id}")
	public String watchProfile(Model model, @PathVariable long id, HttpServletRequest request) {
		User follower = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		User following = userService.findById(id).orElseThrow();
		
		if (!follower.getId().equals(following.getId())) {
			model.addAttribute("userWatch", following);
			model.addAttribute("user", follower);
			
			model.addAttribute("comments", commentService.findByUser(following,  PageRequest.of(0,5)));
			
			if(!follower.getFollowing().contains(following)) {
				model.addAttribute("follow", "Follow");
			} else {
				model.addAttribute("follow", "Unfollow");
			}
			
			return "watchProfile";
		} else {
			return "redirect:/profile/" + follower.getId();
		}
	}
	
	@GetMapping("/followUnfollow/{id}")
	public String followUnfollow(Model model, @PathVariable long id, HttpServletRequest request) {
		User follower = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		User following = userService.findById(id).orElseThrow();
		
		if(!follower.getFollowing().contains(following)) {
			follower.addFollowing(following);
		} else {
			follower.deleteFollowing(following);
		}
		
		follower.calculateFollowers();
		follower.calculateFollowing();
				
		following.calculateFollowers();
		following.calculateFollowing();
		
		userService.save(follower);
		return"redirect:/watchProfile/" + following.getId();
	}
	
	private void updateImageProfile(User user, MultipartFile imageField) throws IOException, SQLException {
		if (!imageField.isEmpty()) {
			user.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
			user.setImage(true);
		} else {
			User dbUser = userService.findById(user.getId()).orElseThrow();
			
			if (dbUser.getImage()) {
				user.setImageFile(BlobProxy.generateProxy(dbUser.getImageFile().getBinaryStream(), dbUser.getImageFile().length()));
				user.setImage(true);
			}
		}
	}
}