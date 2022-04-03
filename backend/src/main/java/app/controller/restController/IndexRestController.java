package app.controller.restController;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.Film;
import app.model.Genre;
import app.model.Recommendation;
import app.model.User;
import app.model.modelRest.FilmsList;
import app.service.FilmService;
import app.service.RecommendationService;
import app.service.UserService;

@RestController
@RequestMapping("/api/index")
public class IndexRestController {

	@Autowired
	private RecommendationService recommendationService;
	@Autowired
	private FilmService filmService;
	@Autowired
	private UserService userService;

    @GetMapping("/")
	public ResponseEntity<FilmsList> getMenu(HttpServletRequest request) {
    	Principal principal = request.getUserPrincipal();
    	Page<Recommendation> recommendations = null;
        
		if (principal != null && !request.isUserInRole("ADMIN")) {
			Optional<User> user = userService.findByName(request.getUserPrincipal().getName());
			
			if (user.isPresent()) {
				recommendations = recommendationService.findByUser(user.get().getId(), PageRequest.of(0, 6));
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		Page<Film> trending = filmService.findAll(PageRequest.of(0,6));
		Page<Film> action = filmService.findByGenre(Genre.ACTION, PageRequest.of(0,6));
		Page<Film> adventure = filmService.findByGenre(Genre.ADVENTURE, PageRequest.of(0,6));
		Page<Film> animation = filmService.findByGenre(Genre.ANIMATION, PageRequest.of(0,6));
		Page<Film> comedy = filmService.findByGenre(Genre.COMEDY, PageRequest.of(0,6));
		Page<Film> drama = filmService.findByGenre(Genre.DRAMA, PageRequest.of(0,6));
		Page<Film> horror = filmService.findByGenre(Genre.HORROR, PageRequest.of(0,6));
		Page<Film> scifi = filmService.findByGenre(Genre.SCIENCE_FICTION, PageRequest.of(0,6));

		FilmsList listOfFilms = new FilmsList(recommendations, trending, action, adventure, animation, comedy, drama, horror, scifi);
		
		return new ResponseEntity<>(listOfFilms, HttpStatus.OK);
	}
}