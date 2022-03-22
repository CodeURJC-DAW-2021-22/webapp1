package app.controller;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.Film;
import app.model.Genre;
import app.model.User;
import app.modelRest.FilmUser;
import app.modelRest.ListFilmUser;
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
		
		if (film != null) {
			Genre similar = film.getGenre();
			List<Film> similarList = filmService.findByGenreDistinct(similar, film.getId(), PageRequest.of(0,6));
			
			film.setSimilar(similarList);
			
			return new ResponseEntity<>(film, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/regis/{id}")
	public ResponseEntity<FilmUser> getFilmRegistered(@PathVariable long id, HttpServletRequest request) {
		Film film = filmService.findById(id).orElseThrow();
		User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		
		if ((film != null) && (user != null)) {
			Genre similar = film.getGenre();
			List<Film> similarList = filmService.findByGenreDistinct(similar, film.getId(), PageRequest.of(0,6));
			
			film.setSimilar(similarList);
			
			FilmUser filmUser = new FilmUser(film, user);
			
			boolean buttonUnhidden = !commentService.userHasCommented(user.getId(), film);
			filmUser.setButtonUnhidden(buttonUnhidden);
			return new ResponseEntity<>(filmUser, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<FilmUser> getFilmAdmin(@PathVariable long id, HttpServletRequest request) {
		Film film = filmService.findById(id).orElseThrow();
		User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		
		if ((film != null) && (user != null)) {
			Genre similar = film.getGenre();
			List<Film> similarList = filmService.findByGenreDistinct(similar, film.getId(), PageRequest.of(0,6));
			
			film.setSimilar(similarList);
			
			FilmUser filmUser = new FilmUser(film, user);

			return new ResponseEntity<>(filmUser, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping("/{id}/image")
	public ResponseEntity<Object> downloadImage(@PathVariable long id) throws SQLException {
		Optional<Film> film = filmService.findById(id);
		
		if (film.isPresent() && film.get().getImageFile() != null) {
			Resource file = new InputStreamResource(film.get().getImageFile().getBinaryStream());
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg").contentLength(film.get().getImageFile().length()).body(file);
		} else {
			return ResponseEntity.notFound().build();
		}
	}	

	@GetMapping("/searchFilms")
	public ResponseEntity<ListFilmUser> getSearchFilms(String query, HttpServletRequest request) {
		List<Film> films = filmService.findLikeName(query.toLowerCase(), PageRequest.of(0,6));
		Principal principal = request.getUserPrincipal();
		
		ListFilmUser listFilmUser = new ListFilmUser();
		if (principal != null) {
			User user = userService.findByName(principal.getName()).orElseThrow();
			listFilmUser.setUser(user);
		}
		
		if (films != null) {
			listFilmUser.setFilms(films);
		}
		
		if (!films.isEmpty()) {
			listFilmUser.setExist(true);
		}
		
		return new ResponseEntity<>(listFilmUser, HttpStatus.OK); 
	}


}