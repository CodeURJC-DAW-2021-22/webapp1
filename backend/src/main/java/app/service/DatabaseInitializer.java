package app.service;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import app.advice.FilmRepository;
import app.entity.Film;
import app.entity.Genre;
import app.advice.UserRepository;
import app.entity.User;

@Service
public class DatabaseInitializer {

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void init() throws IOException, URISyntaxException {
		Film film1 = new Film("The mitchell vs the machines", "30/04/2021", "A (All people)", "COMEDY", "114",
				"Abbi Jacobson, Danny McBride, Maya Rudolph, Mike Rianda, Eric Andre, Olivia Colman", "Mike Rianda",
				"The Mitchell family's road trip, escorting one of their children to his first day of college, is interrupted by a technological insurrection that threatens humanity.");
		Film film2 = new Film("Big hero 6", "09/01/2015", "A (All people)", "ADVENTURE", "102",
				"Ryan Potter, Scott Adsit, Daniel Henney, T. J. Miller, Jamie Chung", "Don Hall, Chris Williams",
				"A special bond develops between oversized inflatable robot Baymax and prodigy Hiro Hamada, who team up with a group of friends to form a band of high-tech heroes.");
		Film film3 = new Film("Tangled", "04/02/2011", "A (All people)", "ANIMATION", "100",
				"Mandy Moore, Zachary Levi, Donna Murphy, Jeffrey Tambor, Richard Kiel", "Nathan Greno, Byron Howard",
				"Magical long-haired Rapunzel has spent her entire life in a tower, but now that she's been stumbled upon by an escaped thief, she's about to discover the world for the first time—and who she really is.");
		Film film4 = new Film("The Road to El Dorado", "15/12/2000", "A (All people)", "ANIMATION", "90",
				"Kevin Kline, Kenneth Branagh, Rosie Perez", "Bibo Bergeron, Don Paul",
				"Two swindlers obtain a map that will lead them to the famous city of gold, El Dorado.");
		Film film5 = new Film("The Emperor's New Groove", "10/12/2000", "A (All people)", "ANIMATION", "78",
				"David Spade, John Goodman, Eartha Kitt", "Mark Dindal",
				"Emperor Kuzco was turned into a llama by his former administrator Yzma, and now he must regain his throne with the help of Pacha, a kind llama herder.");
		Film film6 = new Film("The King's Man: The first mission", "22/12/2021",
				"16 (Not suitable for people under 16)", "ACTION", "131",
				"Daniel Brühl, Rhys Ifans, Matthew Goode, Aaron Taylor-Johnson", "Matthew Vaughn",
				"The criminal minds and the greatest tyrants in history plan to annihilate millions of people. A man will fight against time to avoid the worst. Thus, the first independent intelligence agency in the United Kingdom was born.");
		Film film7 = new Film("Tenet", "03/09/2020", "12 (Not suitable for people under 12)", "ACTION", "150",
				"John David Washington, Robert Pattinson, Elizabeth Debicki, Dimple Kapadia, Michael Caine, Kenneth Branagh",
				"Christopher Nolar",
				"Armed with a single word, Tenet, and fighting for the survival of the world, the protagonist travels through the dark world of international espionage on a mission that will go beyond real time.");
		Film film8 = new Film("Eternals", "03/11/2021", "12 (Not suitable for people under 12)", "ACTION", "157",
				"Salma Hayek, Angelina Jolie, Gemma Chan, Richard Madden, Kumail Nanjiani, Lia McHugh, Brian Tyree Henry, Lauren Ridloff, Barry Keoghan, Don Lee, Harish Patel, Kit Harington",
				"Chloé Zhao",
				"Millions of years ago, the cosmic beings known as the Celestials decided to genetically experiment on humans, and shaped our history and civilizations.");

		/*
		 * 2 de aventura, 2 de comedia, 3 de drama, 3 de horror, 3 de ciencia ficción
		 * Film film = new Film("", "", "", "", "", "", "", "");
		 * Film film = new Film("", "", "", "", "", "", "", "");
		 * Film film = new Film("", "", "", "", "", "", "", "");
		 */

		setFilmImage(film1, "/static/Images/film1.jpg");
		setFilmImage(film2, "/static/Images/film2.jpg");
		setFilmImage(film3, "/static/Images/film3.jpg");
		setFilmImage(film4, "/static/Images/film4.jpg");
		setFilmImage(film5, "/static/Images/film5.jpg");
		setFilmImage(film6, "/static/Images/film6.jpeg");
		setFilmImage(film7, "/static/Images/film7.jpg");
		setFilmImage(film8, "/static/Images/film8.jpg");

		filmRepository.save(film1);
		filmRepository.save(film2);
		filmRepository.save(film3);
		filmRepository.save(film4);
		filmRepository.save(film5);
		filmRepository.save(film6);
		filmRepository.save(film7);
		filmRepository.save(film8);

		//User examples
        userRepository.save(new User("user", "user", "pass", passwordEncoder.encode("pass"), "USER"));
        userRepository.save(new User("admin", "admin", "adminpass", passwordEncoder.encode("adminpass"), "USER", "ADMIN"));
	}

	public void setFilmImage(Film film, String classpathResource) throws IOException {
		film.setImage(true);
		Resource image = new ClassPathResource(classpathResource);
		film.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
	}

}