package app.service;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import app.advice.FilmRepository;
import app.entity.Film;
import app.entity.Genre;

@Service
public class DatabaseInitializer {
	
	@Autowired 
	private FilmRepository filmRepository;
	
	@PostConstruct
	public void init() throws IOException, URISyntaxException {
		Film film1 = new Film("Lo posible", "04/01/2001", "A (All people)", Genre.ADVENTURE, 120, "casting asdaw", "Una patata", "Ola grande mata");
		Film film2 = new Film("Lo imposible", "04/01/2001", "A (All people)", Genre.ADVENTURE, 120, "casting asdaw", "Una patata", "Ola grande mata");
	
		setFilmImage(film1, "/static/Images/film10.jpg");
		setFilmImage(film2, "/static/Images/film10.jpg");
		
		filmRepository.save(film1);
		filmRepository.save(film2);
	}
	
	public void setFilmImage(Film film, String classpathResource) throws IOException {
		film.setImage(true);
		Resource image = new ClassPathResource(classpathResource);
		film.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
	}
	
}