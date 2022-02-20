package AdviceMe.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Entities.Customer;


@Controller
public class ControllerIndex {
	
	//@Autowired
	//private UsersRepository users;
	
	@GetMapping("/")
	public String adviceMe(Model model) {
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
			Customer customer = new Customer(name, email, pass);
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