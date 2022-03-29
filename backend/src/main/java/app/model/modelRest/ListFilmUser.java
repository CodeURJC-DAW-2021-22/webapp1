package app.model.modelRest;

import org.springframework.data.domain.Page;

import app.model.Film;
import app.model.User;

public class ListFilmUser {
	
	private Page<Film> films;
	private User user;
	private Boolean exist;

	public ListFilmUser() {

	}
	
	public ListFilmUser(Page<Film> film, User user) {
		this.films = film;
		this.user = user;
	}

	public void setExist(Boolean exist) {
		this.exist = exist;
	}

	public Page<Film> getFilms() {
		return films;
	}

	public User getUser() {
		return user;
	}

	
	public Boolean getExist() {
		return exist;
	}

	public void setFilms(Page<Film> films) {
		this.films = films;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}