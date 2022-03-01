package app.advice;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import app.entity.Film;
import app.entity.Genre;
import app.service.FilmService;
//import app.entity.User;

@Controller
public class ControllerIndex {

	@Autowired
	private FilmService filmService;
	
	@GetMapping("/")
	public String adviceMe(Model model) {
		model.addAttribute("trending", filmService.findAll());
		model.addAttribute("action", filmService.findByGenre(Genre.ACTION));
		model.addAttribute("adventure", filmService.findByGenre(Genre.ADVENTURE));
		model.addAttribute("animation", filmService.findByGenre(Genre.ANIMATION));
		model.addAttribute("comedy", filmService.findByGenre(Genre.COMEDY));
		model.addAttribute("drama", filmService.findByGenre(Genre.DRAMA));
		model.addAttribute("horror", filmService.findByGenre(Genre.HORROR));
		model.addAttribute("scifi", filmService.findByGenre(Genre.SCIENCE_FICTION));
		return "adviceMe";
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

	@GetMapping("/menuRegistered")
	public String menuRegistered(Model model, HttpServletRequest request) {
		// Insertar comprobación de que no existen usuarios iguales

		model.addAttribute("username", request.getUserPrincipal().getName());
		if (request.isUserInRole("ADMIN")){
			return "redirect:/menuAdmin";
		}
		else{
			model.addAttribute("trending", filmService.findAll());
			model.addAttribute("action", filmService.findByGenre(Genre.ACTION));
			model.addAttribute("adventure", filmService.findByGenre(Genre.ADVENTURE));
			model.addAttribute("animation", filmService.findByGenre(Genre.ANIMATION));
			model.addAttribute("comedy", filmService.findByGenre(Genre.COMEDY));
			model.addAttribute("drama", filmService.findByGenre(Genre.DRAMA));
			model.addAttribute("horror", filmService.findByGenre(Genre.HORROR));
			model.addAttribute("scifi", filmService.findByGenre(Genre.SCIENCE_FICTION));
			
			//model.addAttribute("recommendation", filmService.);
			//model.addAttribute("commented", filmService.);
			return "menuRegistered";
		}
	}
	
	@GetMapping("/menuAdmin")
	public String menuAdmin(Model model) {
		model.addAttribute("trending", filmService.findAll());
		model.addAttribute("action", filmService.findByGenre(Genre.ACTION));
		model.addAttribute("adventure", filmService.findByGenre(Genre.ADVENTURE));
		model.addAttribute("animation", filmService.findByGenre(Genre.ANIMATION));
		model.addAttribute("comedy", filmService.findByGenre(Genre.COMEDY));
		model.addAttribute("drama", filmService.findByGenre(Genre.DRAMA));
		model.addAttribute("horror", filmService.findByGenre(Genre.HORROR));
		model.addAttribute("scifi", filmService.findByGenre(Genre.SCIENCE_FICTION));	
		//model.addAttribute("recommendation", filmService.);
		//model.addAttribute("commented", filmService.);
		return "menuAdmin";
	}
	
	@GetMapping("/profile")
	public String profile(Model model) {
		return "profile";
	}
	
	@GetMapping("/editProfile")
	public String editProfile(Model model) {
		return "editProfile";
	}
	
	@GetMapping("/filmUnregistered/{id}")
	public String filmUnregistered(Model model, @PathVariable long id) {
		Film film = filmService.findById(id).orElseThrow();
		model.addAttribute("film", film);
		Genre similar = film.getGenre();
		model.addAttribute("similar", filmService.findByGenre(similar));
		return "filmUnregistered";
	} 
	
	@GetMapping("/filmRegistered/{id}")
	public String filmRegistered(Model model, @PathVariable long id) {
		Film film = filmService.findById(id).orElseThrow();
		model.addAttribute("film", film);
		Genre similar = film.getGenre();
		model.addAttribute("similar", filmService.findByGenre(similar));
		return "filmRegistered";
	}
	
	@GetMapping("/filmAdmin/{id}")
	public String filmAdmin(Model model, @PathVariable long id) {
		Film film = filmService.findById(id).orElseThrow();
		model.addAttribute("film", film);
		Genre similar = film.getGenre();
		model.addAttribute("similar", filmService.findByGenre(similar));
		return "filmAdmin";
	}
	
	@GetMapping("/addFilm")
	public String addFilm(Model model) {
		return "addFilm";
	}
	
	@PostMapping("/addFilm")
	public String addFilmProcess(Model model, Film film, MultipartFile imageField) throws IOException {			
		if (!imageField.isEmpty()) {
			film.setImageFile(BlobProxy.generateProxy(imageField.getInputStream(), imageField.getSize()));
			film.setImage(true);
		}
		filmService.save(film);
		model.addAttribute("trending", filmService.findAll());
		model.addAttribute("action", filmService.findByGenre(Genre.ACTION));
		model.addAttribute("adventure", filmService.findByGenre(Genre.ADVENTURE));
		model.addAttribute("animation", filmService.findByGenre(Genre.ANIMATION));
		model.addAttribute("comedy", filmService.findByGenre(Genre.COMEDY));
		model.addAttribute("drama", filmService.findByGenre(Genre.DRAMA));
		model.addAttribute("horror", filmService.findByGenre(Genre.HORROR));
		model.addAttribute("scifi", filmService.findByGenre(Genre.SCIENCE_FICTION));
		//model.addAttribute("recommendation", filmService.);
		//model.addAttribute("commented", filmService.);
		return "menuAdmin";
	}
	
}