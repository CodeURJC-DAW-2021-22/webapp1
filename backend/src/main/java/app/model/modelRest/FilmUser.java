package app.model.modelRest;


import app.model.Film;
import app.model.User;

public class FilmUser {
	
	private Film film;
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