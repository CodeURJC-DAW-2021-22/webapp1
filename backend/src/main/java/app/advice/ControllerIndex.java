package app.advice;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.entity.Film;
import app.entity.Genre;
import app.entity.User;


@Controller
public class ControllerIndex {
	
	@Autowired
	//private UsersRepository users;
	private FilmRepository films;
	
	@PostConstruct
	public void init() {

		this.films.save(new Film("Lo imposible", "04/01/2001", 4, Genre.ADVENTURE, 120, "casting asdaw", "Una patata", "Ola grande mata"));
	}

	@GetMapping("/film/{id}")
	public Film getFilm(@PathVariable long id) {
		return films.findById(id).orElseThrow();
	}           
	
	@GetMapping("/")
	public String adviceMe(Model model) {
		model.addAttribute("films", films.findAll());
		return "adviceMe";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		return "register";
	}
	
	@RequestMapping("/menuRegistered")
	public String menuRegistered(Model model,@RequestParam String name, @RequestParam String email,
			@RequestParam String pass, @RequestParam String passConfirm) {
		// Insertar comprobación de que no existen usuarios iguales
		if((!pass.equals(passConfirm)) && (!pass.isBlank()) && (!passConfirm.isBlank()) ) {
			User customer = new User(name, email, pass);
			//users.save(customer);
			return "menuRegistered";
		}
				
		return "register";
	}
	
	@GetMapping("/menuAdmin")
	public String menuAdmin(Model model) {
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
	
	@GetMapping("/filmRegistered")
	public String filmRegistered(Model model) {
		return "filmRegistered";
	}
	
	@GetMapping("/filmUnregistered")
	public String filmUnregistered(Model model) {
		return "filmUnregistered";
	}
	
	@GetMapping("/filmAdmin")
	public String filmAdmin(Model model) {
		return "filmAdmin";
	}
	
	@GetMapping("/addFilm")
	public String addFilm(Model model) {
		return "addFilm";
	}
	
}