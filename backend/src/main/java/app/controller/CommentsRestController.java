package app.controller;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.Comment;
import app.model.Film;
import app.model.User;
import app.model.Genre;
import app.modelRest.FilmUser;
import app.service.CommentService;
import app.service.FilmService;
import app.service.UserService;

@RestController
@RequestMapping("/api/comments")
public class CommentsRestController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/addCom/{id}")
	public ResponseEntity<FilmUser> getAddComment(@PathVariable long id, HttpServletRequest request){
		Film film = filmService.findById(id).orElseThrow();
		User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		if (!commentService.userHasCommented(user.getId(), film)){
			FilmUser filmUser = new FilmUser(film, user);
			return new ResponseEntity<>(filmUser, HttpStatus.OK);
		} else {
			Genre similar = film.getGenre();
			List<Film> similarList = filmService.findByGenreDistinct(similar, film.getId(), PageRequest.of(0,6));
			
			film.setSimilar(similarList);
			
			FilmUser filmUser = new FilmUser(film, user);

			return new ResponseEntity<>(filmUser, HttpStatus.OK);
		}
	}
	
}