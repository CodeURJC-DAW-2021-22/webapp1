package app.controller;


import java.io.IOException;
import java.security.Principal;
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
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import app.model.Comment;
import app.model.Film;
import app.model.Genre;
import app.model.User;
import app.service.CommentService;
import app.service.FilmService;
import app.service.SendMail;
import app.service.UserService;


@Controller
public class ControllerIndex {

	@Autowired
	private UserService userService;
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@ModelAttribute
	public void addAttributes(Model model, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();

		if (principal != null) {
			model.addAttribute("logged", true);
			model.addAttribute("admin", request.isUserInRole("ADMIN"));
		} else {
			model.addAttribute("logged", false);
		}
	}
	
	@GetMapping("/")
	public String adviceMe(Model model) {	
		model.addAttribute("trending", filmService.findAll(PageRequest.of(0,6)));
		model.addAttribute("action", filmService.findByGenre(Genre.ACTION, PageRequest.of(0,6)));
		model.addAttribute("adventure", filmService.findByGenre(Genre.ADVENTURE, PageRequest.of(0,6)));
		model.addAttribute("animation", filmService.findByGenre(Genre.ANIMATION, PageRequest.of(0,6)));
		model.addAttribute("comedy", filmService.findByGenre(Genre.COMEDY, PageRequest.of(0,6)));
		model.addAttribute("drama", filmService.findByGenre(Genre.DRAMA, PageRequest.of(0,6)));
		model.addAttribute("horror", filmService.findByGenre(Genre.HORROR, PageRequest.of(0,6)));
		model.addAttribute("scifi", filmService.findByGenre(Genre.SCIENCE_FICTION, PageRequest.of(0,6)));

		return "adviceMe";
	}
	
	@GetMapping("/more/{page}")
	public String getFilms(Model model, @PathVariable int page) {
		// Before returning a page it confirms that there are more left
		if (page <= (int) Math.ceil(filmService.count()/6)) {
			model.addAttribute("films", filmService.findAll(PageRequest.of(page,6)));
			return "movies";
		}
		
		return null;
	}
	
	@GetMapping("/moreSearch/{name}/{page}")
	public String getFilmsSeach(Model model, @PathVariable String name, @PathVariable int page) {
		// Before returning a page it confirms that there are more left
		if (page <= (int) Math.ceil(filmService.countByName(name)/6)) {
			model.addAttribute("films", filmService.findLikeName(name, PageRequest.of(page,6)));
			return "movies";
		}
		return null;
	}
	
	@GetMapping("/moreGenre/{genre}/{page}")
	public String getFilmsGenre(Model model, @PathVariable String genre, @PathVariable int page) {
		// Before returning a page it confirms that there are more left
		Genre gen = Genre.valueOf(genre);
		
		if (page <= (int) Math.ceil(filmService.countByGenre(gen)/6)) {
			model.addAttribute("films", filmService.findByGenre(gen, PageRequest.of(page,6)));
			return "movies";
		}
		
		return null;
	}
	
	@GetMapping("/moreComments/{id}/{page}")
	public String getComments(Model model, @PathVariable long id, @PathVariable int page) {
		// Before returning a page it confirms that there are more left
		Optional<Film> film = filmService.findById(id);
		if (page <= (int) Math.ceil(commentService.countByFilm(film)/2)) {
			
			model.addAttribute("comments", commentService.findByFilm(film, PageRequest.of(page, 2)));

			return "comments";
		}
		
		return null;
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
	
	@GetMapping("/searchFilms")
	public String searchFilms(Model model, String query) {
		List<Film> result = filmService.findLikeName(query.toLowerCase(), PageRequest.of(0,6));
		model.addAttribute("result", result);
		if (!result.isEmpty()) {
			model.addAttribute("exist", true);
		}
		return "searchFilms";
	}
	
    @RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginerror")
	public String loginerror() {
		return "loginerror";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/registerProcess")
	public String registerProcess(Model model, User user) {
		user.setEncodedPassword(passwordEncoder.encode(user.getEncodedPassword()));
		userService.save(user);
		return "redirect:/login";
	}
	
	@GetMapping("/menuRegistered")
	public String menuRegistered(Model model, HttpServletRequest request) {
    	User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
    	
		if (request.isUserInRole("ADMIN")) {
			return "redirect:/menuAdmin";
		} else {
			model.addAttribute("trending", filmService.findAll(PageRequest.of(0,6)));
			//model.addAttribute("recommendation", filmService.);
			//model.addAttribute("commented", filmService.);
			model.addAttribute("action", filmService.findByGenre(Genre.ACTION, PageRequest.of(0,6)));
			model.addAttribute("adventure", filmService.findByGenre(Genre.ADVENTURE, PageRequest.of(0,6)));
			model.addAttribute("animation", filmService.findByGenre(Genre.ANIMATION, PageRequest.of(0,6)));
			model.addAttribute("comedy", filmService.findByGenre(Genre.COMEDY, PageRequest.of(0,6)));
			model.addAttribute("drama", filmService.findByGenre(Genre.DRAMA, PageRequest.of(0,6)));
			model.addAttribute("horror", filmService.findByGenre(Genre.HORROR, PageRequest.of(0,6)));
			model.addAttribute("scifi", filmService.findByGenre(Genre.SCIENCE_FICTION, PageRequest.of(0,6)));

			model.addAttribute("user", user);
			return "menuRegistered";
		}
	}
	
	@GetMapping("/menuFollowing/{id}")
	public String menuFollowing(Model model, @PathVariable long id) {
		model.addAttribute("user", userService.findById(id).orElseThrow());
		return "menuFollowing";
	}
	
	@GetMapping("/menuAdmin")
	public String menuAdmin(Model model, HttpServletRequest request) {
		model.addAttribute("trending", filmService.findAll(PageRequest.of(0,6)));
		model.addAttribute("action", filmService.findByGenre(Genre.ACTION, PageRequest.of(0,6)));
		model.addAttribute("adventure", filmService.findByGenre(Genre.ADVENTURE, PageRequest.of(0,6)));
		model.addAttribute("animation", filmService.findByGenre(Genre.ANIMATION, PageRequest.of(0,6)));
		model.addAttribute("comedy", filmService.findByGenre(Genre.COMEDY, PageRequest.of(0,6)));
		model.addAttribute("drama", filmService.findByGenre(Genre.DRAMA, PageRequest.of(0,6)));
		model.addAttribute("horror", filmService.findByGenre(Genre.HORROR, PageRequest.of(0,6)));
		model.addAttribute("scifi", filmService.findByGenre(Genre.SCIENCE_FICTION, PageRequest.of(0,6)));
		
		model.addAttribute("user", userService.findByName(request.getUserPrincipal().getName()).orElseThrow());
		return "menuAdmin";
	}
	
	@GetMapping("/profile/{id}")
	public String profile(Model model, @PathVariable long id) {
		model.addAttribute("user", userService.findById(id).orElseThrow());
		return "profile";
	}
	
	@GetMapping("/editProfile/{id}")
	public String editProfile(Model model, @PathVariable long id) {
		model.addAttribute("user", userService.findById(id).orElseThrow());
		
		return "editProfile";
	}
	
	@PostMapping("/editProfile")
	public String editProfileProcess(Model model, User newUser, MultipartFile imageField) throws IOException, SQLException {
		User user = userService.findById(newUser.getId()).orElseThrow();
		updateImageProfile(newUser, imageField);
		user.getComments().forEach(c -> newUser.addComment(c));
		userService.save(newUser);
		return "redirect:/profile/" + user.getId();
	}
	
	@GetMapping("/editComment/{id}")
	public String editComment(Model model, @PathVariable long id) {
		model.addAttribute("comment", commentService.findById(id).orElseThrow());
		
		return "editComment";
	}
	
	@PostMapping("/editComment")
	public String editComment(Model model, Comment newComment) throws IOException, SQLException {
		Comment comment = commentService.findById(newComment.getId()).orElseThrow();
		newComment.setUser(comment.getUser());
		newComment.setFilm(comment.getFilm());
		commentService.save(newComment);
		return "redirect:/profile/" + newComment.getUser().getId();
	}
	
	@GetMapping("/followers")
	public String followers(Model model) {
		return "followers";
	}
	
	@GetMapping("/addFollowing/{id}")
	public String addFollowing(Model model, @PathVariable long id, HttpServletRequest request) {
		User follower = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		User following = userService.findById(id).orElseThrow();
		if(!follower.getFollowing().contains(following)) {
			follower.addFollowing(following);
		} else {
			follower.deleteFollowing(following);
		}
		userService.save(following);
		userService.save(follower);
		return"redirect:/watchProfile/" + following.getId();
	}
	
	@GetMapping("/watchProfile/{id}")
	public String watchProfile(Model model, @PathVariable long id) {
		model.addAttribute("user", userService.findById(id).orElseThrow());
		return "watchProfile";
	}
	
	@GetMapping("/filmUnregistered/{id}")
	public String filmUnregistered(Model model, @PathVariable long id) {
		Film film = filmService.findById(id).orElseThrow();
		model.addAttribute("film", film);
		model.addAttribute("comments", commentService.findByFilm(film, PageRequest.of(0,2)));
		Genre similar = film.getGenre();
		model.addAttribute("similar", filmService.findByGenre(similar));
		return "filmUnregistered";
	} 
	
	@GetMapping("/filmRegistered/{id}")
	public String filmRegistered(Model model, @PathVariable long id) {
		Film film = filmService.findById(id).orElseThrow();
		model.addAttribute("film", film);
		model.addAttribute("comments", commentService.findByFilm(film, PageRequest.of(0,2)));
		Genre similar = film.getGenre();
		model.addAttribute("similar", filmService.findByGenre(similar));
		return "filmRegistered";
	}
	
	@GetMapping("/addComment/{id}")
	public String addComent(Model model, @PathVariable long id, HttpServletRequest request) {
		Film film = filmService.findById(id).orElseThrow();
		User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		model.addAttribute("film", film);
		model.addAttribute("user", user);
		return"addComment";
	}
	
	@PostMapping("/addComment/{id}")
	public String addComment(Model model, @PathVariable long id, Comment comment, HttpServletRequest request) {
		Film film = filmService.findById(id).orElseThrow();
		User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		comment.setFilm(film);
		comment.setUser(user);
		commentService.save(comment);
		return"redirect:/filmRegistered/" + film.getId();
	}
	
	@GetMapping("/removeComment/{id}")
	public String removeComment(Model model, @PathVariable long id, HttpServletRequest request) {
		Comment comment = commentService.findById(id).orElseThrow();
		User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		User userComment = comment.getUser();
		
		if (userComment.getId() == user.getId() || request.isUserInRole("ADMIN")) {
			Film film = comment.getFilm();
			commentService.delete(id);
			film.calculateAverage();
			filmService.save(film);
			
			if (request.isUserInRole("ADMIN")) {
				return "redirect:/filmAdmin/" + film.getId();
			} else {
				return "redirect:/profile/" + user.getId();
			}
		} 
		
		return "redirect:/menuRegistered";
	}
	
	@GetMapping("/filmAdmin/{id}")
	public String filmAdmin(Model model, @PathVariable long id, HttpServletRequest request) {
		Film film = filmService.findById(id).orElseThrow();
		User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		model.addAttribute("film", film);
		model.addAttribute("comments", commentService.findByFilm(film, PageRequest.of(0,2)));
		model.addAttribute("user", user);
		Genre similar = film.getGenre();
		model.addAttribute("similar", filmService.findByGenre(similar));
		return "filmAdmin";
	}
	
	@GetMapping("/removeFilm/{id}")
	public String removeFilm(Model model, @PathVariable long id) {
		Optional<Film> film = filmService.findById(id);
		
		if (film.isPresent()) {
			filmService.delete(id);
		}
		
		return "redirect:/menuAdmin";
	}
	
	@GetMapping("/addFilm")
	public String addFilm(Model model, HttpServletRequest request) {
		User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
		model.addAttribute("user", user);
		return "addFilm";
	}
	
	@PostMapping("/addFilm")
	public String addFilmProcess(Model model, Film film, MultipartFile imageField) throws IOException {			
		if (!imageField.isEmpty()) {
			film.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
			film.setImage(true);
		}
		
		filmService.save(film);
		SendMail.sendMail();
		
		return "redirect:/menuAdmin";
	}
	
	@GetMapping("/editFilm/{id}")
	public String editFilm(Model model, @PathVariable long id, HttpServletRequest request) {
		Optional<Film> film = filmService.findById(id);
		
		if (film.isPresent()) {
			User user = userService.findByName(request.getUserPrincipal().getName()).orElseThrow();
			model.addAttribute("user", user);
			model.addAttribute("film", film.get());
			return "editFilmPage";
		}
		
		return "redirect:/menuAdmin";
	}
	
	@PostMapping("/editFilm/{id}")
	public String editFilmProcess(Model model, Film newFilm, @PathVariable long id, MultipartFile imageField) throws IOException, SQLException {
		Film film = filmService.findById(id).orElseThrow();
		updateImage(newFilm, imageField);
		film.getComments().forEach(c -> newFilm.addComment(c));
		filmService.save(newFilm);
		
		return "redirect:/filmAdmin/" + film.getId();
	}
	
	private void updateImage(Film film, MultipartFile imageField) throws IOException, SQLException {
		if (!imageField.isEmpty()) {
			film.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
			film.setImage(true);
		} else {
			Film dbFilm = filmService.findById(film.getId()).orElseThrow();
			
			if (dbFilm.getImage()) {
				film.setImageFile(BlobProxy.generateProxy(dbFilm.getImageFile().getBinaryStream(),
						dbFilm.getImageFile().length()));
				film.setImage(true);
			}
		}
	}
	
	private void updateImageProfile(User user, MultipartFile imageField) throws IOException, SQLException {
		if (!imageField.isEmpty()) {
			user.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
			user.setImage(true);
		} else {
			User dbUser = userService.findById(user.getId()).orElseThrow();
			
			if (dbUser.getImage()) {
				user.setImageFile(BlobProxy.generateProxy(dbUser.getImageFile().getBinaryStream(),
						dbUser.getImageFile().length()));
				user.setImage(true);
			}
		}
	}
}