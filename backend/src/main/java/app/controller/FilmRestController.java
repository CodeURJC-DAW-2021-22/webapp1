package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.Film;
import app.model.Genre;
import app.service.CommentService;
import app.service.FilmService;
import app.service.UserService;

@RestController
@RequestMapping("/api/films")
public class FilmRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Film> getfilmUnregistered(@PathVariable long id) {
		Film film = filmService.findById(id).orElseThrow();
		//Genre similar = film.getGenre();
		//List<Film> similarList = filmService.findByGenreDistinct(similar, film.getId(), PageRequest.of(0,6));
		
		//film.setSimilar(similarList);
		
		return new ResponseEntity<>(film, HttpStatus.OK);
	} 
}