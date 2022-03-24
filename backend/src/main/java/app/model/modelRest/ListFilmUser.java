package app.model.modelRest;

import java.util.List;

import app.model.Film;
import app.model.User;

public class ListFilmUser {
	
	private List<Film> films;
	private User user;
	private Boolean exist;

	public ListFilmUser() {

	}
	
	public ListFilmUser(List<Film> film, User user) {
		this.films = film;
		this.user = user;
	}

	public void setExist(Boolean exist) {
		this.exist = exist;
	}

	public List<Film> getFilms() {
		return films;
	}

	public User getUser() {
		return user;
	}

	
	public Boolean getExist() {
		return exist;
	}

	public void setFilms(List<Film> films) {
		this.films = List.copyOf(films);
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}