package app.controller.restController;

import java.io.IOException;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.model.Film;
import app.model.Genre;
import app.model.User;
import app.model.modelRest.FilmsList;
import app.service.FilmService;
import app.service.UserService;

@RestController
@RequestMapping("/api/index")
public class IndexRestController {
	
	@Autowired
	private FilmService filmService;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/adviceMe")
	public ResponseEntity<FilmsList> getAdviceMe(){
		Page<Film> trending = filmService.findAll(PageRequest.of(0,6));
		Page<Film> action = filmService.findByGenre(Genre.ACTION, PageRequest.of(0,6));
		Page<Film> adventure = filmService.findByGenre(Genre.ADVENTURE, PageRequest.of(0,6));
		Page<Film> animation = filmService.findByGenre(Genre.ANIMATION, PageRequest.of(0,6));
		Page<Film> comedy = filmService.findByGenre(Genre.COMEDY, PageRequest.of(0,6));
		Page<Film> drama = filmService.findByGenre(Genre.DRAMA, PageRequest.of(0,6));
		Page<Film> horror = filmService.findByGenre(Genre.HORROR, PageRequest.of(0,6));
		Page<Film> scifi = filmService.findByGenre(Genre.SCIENCE_FICTION, PageRequest.of(0,6));

		FilmsList listOfFilms = new FilmsList(trending, action, adventure, animation,
				comedy, drama, horror, scifi);
		
		return new ResponseEntity<>(listOfFilms, HttpStatus.OK);
	}
	
	@PostMapping("/registerProcess")
	@ResponseStatus(HttpStatus.CREATED)
	public User registerProcess(@RequestBody User user) throws IOException {
		if (!userService.existName(user.getName())) {
			Resource image = new ClassPathResource("/static/Images/defaultImage.png");
			user.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
			user.setImage(true);
			user.setEncodedPassword(passwordEncoder.encode(user.getEncodedPassword()));
			userService.save(user);
			return user; //login
		} else {
			return null; //takenUserName
		}
	}
	
}