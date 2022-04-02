package app.controller.restController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import app.model.User;
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
		Optional<User> user = userService.findById(id);
		
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/me")
	public ResponseEntity<User> me(HttpServletRequest request) {
		Optional<User> user = userService.findByName(request.getUserPrincipal().getName());
		
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}/image")
	public ResponseEntity<Object> downloadImageProfile(@PathVariable long id) throws SQLException {
		Optional<User> user = userService.findById(id);
		
	    if (user.isPresent() && user.get().getImageFile() != null) {
	        Resource file = new InputStreamResource(user.get().getImageFile().getBinaryStream());
	        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg").contentLength(user.get().getImageFile().length()).body(file);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping("/")
	public ResponseEntity<User> register(@RequestBody User user) throws IOException {
		if (!userService.existName(user.getName())) {
			Resource image = new ClassPathResource("/static/Images/defaultImage.png");
			user.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
			user.setImage(true);
			user.setEncodedPassword(passwordEncoder.encode(user.getEncodedPassword()));
			userService.save(user);
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); //takenUserName
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> editProfile(@PathVariable long id, @RequestBody User newUser) throws IOException, SQLException {
		Optional<User> optionalUser = userService.findById(id);
		
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
		    user.setEmail(newUser.getEmail());
		    userService.save(user);
		    return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}/image")
	public ResponseEntity<Object> editImage(@PathVariable long id, @RequestParam MultipartFile imageFile) throws IOException{
		Optional<User> optionalUser = userService.findById(id);
		
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			user.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
			userService.save(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@PutMapping("/{id}/password")
	public ResponseEntity<User> editPassword(@PathVariable long id, @RequestParam String oldPassword, @RequestParam String newPassword) throws IOException, SQLException {
		Optional<User> optionalUser = userService.findById(id); 
		
		if (optionalUser.isPresent()) {
			User user = optionalUser.get();
			
			if (passwordEncoder.matches(oldPassword, user.getEncodedPassword())){
				user.setEncodedPassword(passwordEncoder.encode(newPassword));
				userService.save(user);
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}/followers")
	public ResponseEntity<List<User>> followers(@PathVariable long id, HttpServletRequest request) {
		Optional<User> user = userService.findById(id);
		
		if (user.isPresent()) {
			List<User> followers = user.get().getFollowers();
			return new ResponseEntity<>(followers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}/following")
	public ResponseEntity<List<User>> following(@PathVariable long id, HttpServletRequest request) {		
		Optional<User> user = userService.findById(id);
		
		if (user.isPresent()) {
			List<User> following = user.get().getFollowing();
			return new ResponseEntity<>(following, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{id}/followed")
	public ResponseEntity<User> followUnfollow(@PathVariable long id, HttpServletRequest request) {
		User follower = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		User following = userService.findById(id).orElseThrow();
		
		if (!follower.getFollowing().contains(following)) {
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
}