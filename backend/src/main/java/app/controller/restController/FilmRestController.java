package app.controller.restController;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.io.IOException;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import app.model.Comment;
import app.model.Film;
import app.model.Genre;
import app.model.modelRest.FilmComments;
import app.service.CommentService;
import app.service.FilmService;

@RestController
@RequestMapping("/api/films")
public class FilmRestController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/{id}")
	public ResponseEntity<FilmComments> getFilm(@PathVariable long id) {
		Optional<Film> optionalFilm = filmService.findById(id);
		
		if (optionalFilm.isPresent()) {
			Film film = optionalFilm.get();
			
			Genre similar = film.getGenre();
			Page<Film> similarList = filmService.findByGenreDistinct(similar, film.getId(), PageRequest.of(0,6));
			
			film.setSimilar(similarList.toList());
			Page<Comment> comments = commentService.findByFilm(film, PageRequest.of(0,2));
			FilmComments filmComments = new FilmComments(film, comments);
			return new ResponseEntity<>(filmComments, HttpStatus.OK);
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

	@GetMapping("/")
	public List<Film> searchFilms(String query) {
		Page<Film> films = filmService.findLikeName(query.toLowerCase(), PageRequest.of(0,6));
		return films.toList(); 
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Film addFilm(@RequestBody Film film) {					
		filmService.save(film);		
		return film;
	}
	
	@PostMapping("/{id}/image")
	public ResponseEntity<Object> uploadImage(@PathVariable long id, @RequestParam MultipartFile imageFile) throws IOException{
		Optional<Film> optionalFilm = filmService.findById(id);
		
		if (optionalFilm.isPresent()) {
			Film film = optionalFilm.get();
			URI location = fromCurrentRequest().build().toUri();
			
			film.setImage(true);
			film.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
			
			filmService.save(film);
			return ResponseEntity.created(location).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}/image")
	public ResponseEntity<Object> editImage(@PathVariable long id, @RequestParam MultipartFile imageFile) throws IOException{
		Optional<Film> optionalFilm = filmService.findById(id);
		
		if (optionalFilm.isPresent()) {
			Film film = optionalFilm.get();
			film.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
			filmService.save(film);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Film> editFilm(@RequestBody Film newFilm, @PathVariable long id) {
		Optional<Film> optionalFilm = filmService.findById(id);

	    if (optionalFilm.isPresent()) {
	    	Film film = optionalFilm.get();
	    	film.setTitle(newFilm.getTitle());
			film.setReleaseDate(newFilm.getReleaseDate());
			film.setCast(newFilm.getCast());
			film.setDuration(newFilm.getDuration());
			film.setMinAge(newFilm.getMinAge());
			film.setGenre(newFilm.getGenre());
			film.setDirector(newFilm.getDirector());
			film.setPlot(newFilm.getPlot());
			
			filmService.save(film);
	        return new ResponseEntity<>(film, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Film> removeFilm(@PathVariable long id) {
		Optional<Film> film = filmService.findById(id);
			
		if (film.isPresent()) {
			filmService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}