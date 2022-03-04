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

import app.entity.Comment;
//import app.entity.Genre;
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
		if (filmRepository.count() == 0) {
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
			Film film6 = new Film("The King's Man: The first mission", "22/12/2021", "16 (Not suitable for people under 16)", "ACTION", "131",
					 "Daniel Brühl, Rhys Ifans, Matthew Goode, Aaron Taylor-Johnson", "Matthew Vaughn", "The criminal minds and the greatest tyrants in history plan to annihilate millions of people. A man will fight against time to avoid the worst. Thus, the first independent intelligence agency in the United Kingdom was born.");
			Film film7 = new Film("Tenet", "03/09/2020", "12 (Not suitable for people under 12)", "ACTION", "150",
					"John David Washington, Robert Pattinson, Elizabeth Debicki, Dimple Kapadia, Michael Caine, Kenneth Branagh", "Christopher Nolar",
					"Armed with a single word, Tenet, and fighting for the survival of the world, the protagonist travels through the dark world of international espionage on a mission that will go beyond real time.");
			Film film8 = new Film("Eternals", "03/11/2021", "12 (Not suitable for people under 12)", "ACTION", "157",
					"Salma Hayek, Angelina Jolie, Gemma Chan, Richard Madden, Kumail Nanjiani, Lia McHugh, Brian Tyree Henry, Lauren Ridloff, Barry Keoghan, Don Lee, Harish Patel, Kit Harington", "Chloé Zhao", 
					"Millions of years ago, the cosmic beings known as the Celestials decided to genetically experiment on humans, and shaped our history and civilizations.");
			Film film9 = new Film("Journey to the Center of the Earth", "05/09/2008", "A (All people)", "ADVENTURE", "93",
					"Brendan Fraser, Josh Hutcherson, Anita Briem", "Eric Brevig", "On a quest to find out what happened to his missing brother, a scientist, his nephew, and their mountain guide discover a fantastical and dangerous world lost in the center of the Earth.");
			Film film10 = new Film("Jungle Cruise", "13/07/2021", "12 (Not suitable for people under 12)", "ADVENTURE", "127",
					"Dwayne Johnson, Emily Blunt, Jack Whitehall, Édgar Ramírez", "Jaume Collet-Serra", "Based on the Disneyland theme park attraction, in which a small riverboat takes a group of travelers through a jungle full of dangerous animals and reptiles, but with a supernatural element.");
			Film film11 = new Film("Deadpool", "19/02/2016", "18 (Not suitable for people under 18)", "COMEDY", "108", 
					"	Ryan Reynolds, Morena Baccarin, Ed Skrein, T. J. Miller, Gina Carano", "Tim Miller", 
					"A quick-tongued mercenary with a morbid sense of humor undergoes a clandestine operation that leaves him with accelerated healing powers and a quest for revenge.");
			Film film12 = new Film("Meet the Parents", "22/12/2000", "A (All people)", "COMEDY", "108", 
					"Robert De Niro, Ben Stiller, Teri Polo, Blythe Danner", "Jay Roach", "Nurse Greg Focker meets the parents of his girlfriend, whom he wants to ask to marry him. The father turns out to be any boyfriend's worst nightmare.");
			Film film13 = new Film("Hachi: A Dog's Tale", "06/11/2009", "A (All people)", "DRAMA", "93", 
					"Richard Gere, Joan Allen", "Lasse Hallström", "A college professor bonds with an abandoned dog he takes in.");
			Film film14 = new Film("Wonder", "17/11/2017", "A (All people)", "DRAMA", "113", 
					"Julia Roberts, Owen Wilson, Jacob Tremblay", "Stephen Chbosky", "It tells the story of Auggie Pullman, a boy with a facial deformity entering fifth grade, attending a mainstream elementary school for the first time.");
			Film film15 = new Film("Gifted", "07/04/2017", "7 (Not suitable for people under 7)", "DRAMA", "101", 
					"Chris Evans, Mckenna Grace, Lindsay Duncan, Jenny Slate, Octavia Spencer", "Marc Webb", "Frank, a single man raising his prodigy niece Mary, has to fight for her custody against the mother.");
			Film film16 = new Film("Insidius", "11/10/2010", "16 (Not suitable for people under 16)", "HORROR", "103",
					"Patrick Wilson, Rose Byrne, Barbara Hershey", "James Wan", "A family tries to prevent evil spirits from trapping their comatose son.");
			Film film17 = new Film("The Conjuring 2: The Enfield Poltergeist", "28/05/2016", "16 (Not suitable for people under 16)", "HORROR", "134",
					"Vera Farmiga, Patrick Wilson, Frances O'Connor, Madison Wolfe", "James Wan", "Ed and Lorraine Warren travel to North London to help a single mother raising four children alone in a house haunted by a supernatural spirit.");
			Film film18 = new Film("It", "08/09/2017", "16 (Not suitable for people under 16)", "HORROR", "135",
					"Pierce Brosnan, Stefanie Scott, Anna Friel, James Frecheville, Michael Nyqvist", "Andy Muschietti", "In the summer of 1989, a group of bullied children band together to destroy a shape-shifting monster that disguises itself as a clown and preys on the children of Derry, their small town in Maine.");
			Film film19 = new Film("The Darkest Minds", "03/08/2018", "12 (Not suitable for people under 12)", "SCIENCE_FICTION", "104",
					"Amandla Stenberg, Harris Dickinson, Mandy Moore", "Jennifer Yuh Nelson", "Imprisoned by an adult world that now fears anyone under the age of 18, a group of teenagers form a resistance group to fight back and reclaim control over their future.");
			Film film20 = new Film("Race to Witch Mountain", "17/04/2009", "7 (Not suitable for people under 7)", "SCIENCE_FICTION", "98",
					"The Rock, AnnaSophia Robb, Alexander Ludwig", "Andy Fickman", "A Las Vegas taxi driver enlists the help of a UFO expert to protect two brothers with paranormal powers from the clutches of an organization that wants to use them for its nefarious plans.");
			Film film21 = new Film("Ron's Gone Wrong", "27/10/2021", "7 (Not suitable for people under 7)", "SCIENCE_FICTION", "107",
					"Zach Galifianakis, Jack Dylan Grazer, Olivia Colman", "Sarah Smith, Jean-Phillipe Vine, Octavio E. Rodríguez", "Barney, an awkward high school student, has an unusual friendship with Ron, his new device that walks, talks and connects digitally. Ron's malfunction launches them on a journey to learn about true friendship.");
			

			User user = new User("user", "user", passwordEncoder.encode("pass"), "USER");
			User admin = new User("admin", "admin", passwordEncoder.encode("adminpass"), "USER", "ADMIN");

			//User examples
	        userRepository.save(user);
	        userRepository.save(admin);
			
			Comment com1 = new Comment("5", "This film is awesome");
			Comment com2 = new Comment("4", "I liked it");
			
			com1.setUser(user);
			com2.setUser(user);
			
			com1.setFilm(film1);
			com2.setFilm(film2);
			
			film1.addComment(com1);
			film2.addComment(com2);

			setFilmImage(film1, "/static/Images/film1.jpg");
			setFilmImage(film2, "/static/Images/film2.jpg");
			setFilmImage(film3, "/static/Images/film3.jpg");
			setFilmImage(film4, "/static/Images/film4.jpg");
			setFilmImage(film5, "/static/Images/film5.jpg");
			setFilmImage(film6, "/static/Images/film6.jpeg");
			setFilmImage(film7, "/static/Images/film7.jpg");
			setFilmImage(film8, "/static/Images/film8.jpg");
			setFilmImage(film9, "/static/Images/film9.jpg");
			setFilmImage(film10, "/static/Images/film10.jpg");
			setFilmImage(film11, "/static/Images/film11.jpg");
			setFilmImage(film12, "/static/Images/film12.jpg");
			setFilmImage(film13, "/static/Images/film13.jpg");
			setFilmImage(film14, "/static/Images/film14.jpg");
			setFilmImage(film15, "/static/Images/film15.jpg");
			setFilmImage(film16, "/static/Images/film16.jpg");
			setFilmImage(film17, "/static/Images/film17.jpg");
			setFilmImage(film18, "/static/Images/film18.jpg");
			setFilmImage(film19, "/static/Images/film19.jpg");
			setFilmImage(film20, "/static/Images/film20.jpg");
			setFilmImage(film21, "/static/Images/film21.jpg");

			filmRepository.save(film1);
			filmRepository.save(film2);
			filmRepository.save(film3);
			filmRepository.save(film4);
			filmRepository.save(film5);
			filmRepository.save(film6);
			filmRepository.save(film7);
			filmRepository.save(film8);
			filmRepository.save(film9);
			filmRepository.save(film10);
			filmRepository.save(film11);
			filmRepository.save(film12);
			filmRepository.save(film13);
			filmRepository.save(film14);
			filmRepository.save(film15);
			filmRepository.save(film16);
			filmRepository.save(film17);
			filmRepository.save(film18);	
			filmRepository.save(film19);
			filmRepository.save(film20);
			filmRepository.save(film21);
			//user.addComment(com1);
			//user.addComment(com2);
		} else {
			return;
		}
	}

	public void setFilmImage(Film film, String classpathResource) throws IOException {
		film.setImage(true);
		Resource image = new ClassPathResource(classpathResource);
		film.setImageFile(BlobProxy.generateProxy(image.getInputStream(), image.contentLength()));
	}

}