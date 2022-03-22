package app.modelRest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import app.model.Film;
import app.model.User;

@Entity
public class FilmUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Transient
	private Film film;
	@Transient
	private User user;
	@Transient
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

	public long getId() {
		return id;
	}

	public Film getFilm() {
		return film;
	}

	public User getUser() {
		return user;
	}

	public Boolean getButtonUnhidden() {
		return buttonUnhidden;
	}
	
}