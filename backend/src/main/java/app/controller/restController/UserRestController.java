package app.controller.restController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import app.model.User;
import app.model.modelRest.ListFollowUser;
import app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getProfile(@PathVariable long id) {
		User user = userService.findById(id).orElseThrow();
		
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
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
	public ResponseEntity<User> editProfile(@PathVariable long id, HttpServletRequest request) {
		User user = userService.findById(id).orElseThrow();
		User userRequest = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		if (user.getId().equals(userRequest.getId())) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/editProfile")
	public ResponseEntity<User> editProfileProcess(Model model, User newUser, MultipartFile imageField) throws IOException, SQLException {
		User user = userService.findById(newUser.getId()).orElseThrow();
		updateImageProfile(user, imageField);
		String newName = newUser.getName();
	    if (!user.getName().equals(newName) && userService.existName(newName)) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	
	    user.setName(newName);
	    user.setEmail(newUser.getEmail());
	    userService.save(user);
	    return new ResponseEntity<>(newUser, HttpStatus.OK);
	}
	
	@GetMapping("/editPassword/{id}")
	public ResponseEntity<User> editPassword(Model model, @PathVariable long id, HttpServletRequest request) {
		User user = userService.findById(id).orElseThrow();
		User userRequest = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		if (user.getId().equals(userRequest.getId())) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/editPassword")
	public ResponseEntity<User> editPasswordProcess(Model model, @RequestParam long id, @RequestParam String oldPassword, @RequestParam String newPassword) throws IOException, SQLException {
		User user = userService.findById(id).orElseThrow(); 
		
		if (passwordEncoder.matches(oldPassword, user.getEncodedPassword())){
			user.setEncodedPassword(passwordEncoder.encode(newPassword));
			userService.save(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/followers/{id}")
	public ResponseEntity<ListFollowUser> followers(Model model, @PathVariable long id, HttpServletRequest request) {
		User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		List<User> followers = user.getFollowers();
		ListFollowUser listFollowersUser = new ListFollowUser();
		listFollowersUser.setUser(user);
		listFollowersUser.setFollowers(followers);
		
		return new ResponseEntity<>(listFollowersUser, HttpStatus.OK);
	}
	
	@GetMapping("/following/{id}")
	public ResponseEntity<ListFollowUser> following(Model model, @PathVariable long id, HttpServletRequest request) {		
		User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		List<User> following = user.getFollowing();
		ListFollowUser listFollowingUser = new ListFollowUser();
		listFollowingUser.setUser(user);
		listFollowingUser.setFollowers(following);
		
		return new ResponseEntity<>(listFollowingUser, HttpStatus.OK);
	}
	
	@GetMapping("/watchProfile/{id}")
	public ResponseEntity<User> watchProfile(Model model, @PathVariable long id, HttpServletRequest request) {
		User follower = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		User following = userService.findById(id).orElseThrow();
		
		if (!follower.getId().equals(following.getId())) {
			
			return new ResponseEntity<>(following, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(follower, HttpStatus.OK);
		}
	}
	
	@GetMapping("/followUnfollow/{id}")
	public ResponseEntity<User> followUnfollow(Model model, @PathVariable long id, HttpServletRequest request) {
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
		return new ResponseEntity<>(following, HttpStatus.OK);
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