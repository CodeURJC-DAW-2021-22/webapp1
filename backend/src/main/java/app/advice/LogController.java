package app.advice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LogController{
    
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