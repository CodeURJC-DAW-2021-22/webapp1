package app.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.entity.User;

@Controller
public class LogController{

	@Autowired
	private UserRepository userRepository;
    
    @GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/loginerror")
	public String loginerror() {
		return "loginerror";
	}

	@GetMapping("/register")
	public String register(Model model) {
		return "register";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}

	@GetMapping("/menuRegistered")
	public String menuRegistered(Model model, HttpServletRequest request) {

		String name = request.getUserPrincipal().getName();
		
		User user = userRepository.findByName(name).orElseThrow();

		model.addAttribute("username", user.getName());		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));

		return "menuRegistered";
	}
}