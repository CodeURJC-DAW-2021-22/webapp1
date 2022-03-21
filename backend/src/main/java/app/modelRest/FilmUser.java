package app.modelRest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import app.model.Film;
import app.model.User;

@Entity
public class FilmUser {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private Film film;
	@OneToOne
	private User user;
	
	private Boolean buttonUnhidden;

	public FilmUser() {

	}
	
	public FilmUser(Film film, User user) {
		this.film = film;
		this.user = user;
	}


	public void setButtonUnhidden(Boolean buttonUnhidden) {
		this.buttonUnhidden = buttonUnhidden;
	}
	
	
}