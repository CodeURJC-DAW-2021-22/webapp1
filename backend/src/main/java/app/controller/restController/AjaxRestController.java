package app.controller.restController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.Comment;
import app.model.Film;
import app.model.Genre;
import app.model.Recommendation;
import app.model.User;
import app.service.CommentService;
import app.service.FilmService;
import app.service.RecommendationService;
import app.service.UserService;

@RestController
@RequestMapping("/api/ajax")
public class AjaxRestController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecommendationService recommendationService;
	
	@GetMapping("/more")
	public Page<Film> getFilms(int page) {
		// Before returning a page it confirms that there are more left
		if (page <= (int) Math.ceil(filmService.count()/6)) {
			return filmService.findAll(PageRequest.of(page,6));
		} else {
			return null;
		}
	}
	
	@GetMapping("/moreRecommendations")
	public Page<Recommendation> getFilmsRecommended(int page, HttpServletRequest request) {
		// Before returning a page it confirms that there are more left
		User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		
		if (page <= (int) Math.ceil(recommendationService.countByUser(user.getId())/6)) {
			return recommendationService.findByUser(user.getId(), PageRequest.of(page,6));
		} else {
			return null;
		}		
	}

	@GetMapping("/moreSearch")
	public Page<Film> getFilmsSearch(String name, int page) {
		// Before returning a page it confirms that there are more left
		if (page <= (int) Math.ceil(filmService.countByName(name)/6)) {
			return filmService.findLikeName(name, PageRequest.of(page,6));
		} else {
			return null;			
		}		
	}
	
	@GetMapping("/moreGenre")
	public Page<Film> getFilmsGenre(String genre, int page) {
		// Before returning a page it confirms that there are more left
		Genre gen = Genre.valueOf(genre);
		
		if (page <= (int) Math.ceil(filmService.countByGenre(gen)/6)) {
			return filmService.findByGenre(gen, PageRequest.of(page,6));
		} else {
			return null;	
		}
	}

	@GetMapping("/moreComments/{id}")
	public Page<Comment> getComments(Model model, @PathVariable long id, int page) {
		// Before returning a page it confirms that there are more left
		Film film = filmService.findById(id).orElseThrow();
		
		if (page <= (int) Math.ceil(commentService.countByFilm(film)/2)) {
			return commentService.findByFilm(film, PageRequest.of(page, 2));
		} else {
			return null;
		}		
	}
	
	@GetMapping("/moreCommentsProfile/{id}")
	public Page<Comment> getCommentsProfile(Model model, @PathVariable long id, int page) {
	    // Before returning a page it confirms that there are more left
	    User user = userService.findById(id).orElseThrow();

	    if (page <= (int) Math.ceil(commentService.countByUser(user)/5)) {
	        return commentService.findByUser(user, PageRequest.of(page, 5));
	    } else {
	        return null;            
	    }
	}

	@GetMapping("/moreFollowers/{id}")
	public Page<User> getFollowers(Model model, @PathVariable long id, int page) {
	    // Before returning a page it confirms that there are more left
	    User user = userService.findById(id).orElseThrow();

	    if (page <= (int) Math.ceil(user.getFollowersCount()/5)) {
	        return userService.findFollowingById(id, PageRequest.of(page, 5));
	    } else {
	        return null;            
	    }
	}
	
	@GetMapping("/moreFollowing/{id}")
	public Page<User> getFollowing(Model model, @PathVariable long id, int page) {
	    // Before returning a page it confirms that there are more left
	    User user = userService.findById(id).orElseThrow();

	    if (page <= (int) Math.ceil(user.getFollowingCount()/5)) {
	        return  userService.findFollowersById(id, PageRequest.of(page, 5));
	    } else {
	        return null;    
	    }
	}
}