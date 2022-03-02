package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
 
@Service
public class MessageAutomatic{
	
	@Autowired
	private JavaMailSender mailSender;

	private String destinatario = "exampleapp35@gmail.com";
 
	public void sendEmail(String nameFilm, String from){

		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(from);
		email.setTo(destinatario);
		email.setSubject("New film");
		email.setText(nameFilm);
		mailSender.send(email);
	}
 
}