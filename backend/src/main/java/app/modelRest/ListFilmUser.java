package app.modelRest;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import app.model.Film;
import app.model.User;

@Entity
public class ListFilmUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Transient
	private List<Film> films;
	@Transient
	private User user;
	@Transient
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

	public long getId() {
		return id;
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