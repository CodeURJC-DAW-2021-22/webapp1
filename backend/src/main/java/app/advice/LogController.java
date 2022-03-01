package app.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.entity.User;
import app.service.UserService;


@Controller
public class LogController{
	
	@Autowired
	private UserService userService;
    
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

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}	

}