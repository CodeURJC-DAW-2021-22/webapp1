package app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import app.model.User;
import app.service.CommentService;
import app.service.FilmService;
import app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private CommentService commentService;
	
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
	public ResponseEntity<User> editProfile(Model model, @PathVariable long id, HttpServletRequest request) {
		User user = userService.findById(id).orElseThrow();
		User userRequest = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		if (user.getId().equals(userRequest.getId())) {
			model.addAttribute("user", user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}