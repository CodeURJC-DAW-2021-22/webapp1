package app.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import app.service.MessageAutomatic;


@RestController
public class SendMailController {

    @Autowired
    private MessageAutomatic mailService;

    @PostMapping
    public String sendMail(String nameFilm, String from){
        return mailService.sendEmail(nameFilm,from);
    }
}