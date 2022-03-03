package app.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
 
@Service
public class messageAutomatic{
	
	@Autowired
	private JavaMailSender mailSender;

	private String destinatario = "exampleapp35@gmail.com";
 
	public String sendEmail(String nameFilm, String from){

		MimeMessage msg = mailSender.createMimeMessage();
		try{
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);
			helper.setFrom(from);
			helper.setTo(destinatario);
			helper.setSubject("New film");
			helper.setText(nameFilm);
			mailSender.send(msg);
		}catch(Exception e){
			return "correo fallido"+e.getMessage();
		}
		return "correo enviado";
	}
 
}
