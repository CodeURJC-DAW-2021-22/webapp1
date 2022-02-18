package AdviceMe.advice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerIndex {

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
	
	@GetMapping("/menuRegistered")
	public String menuRegistered(Model model) {
		return "menuRegistered";
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