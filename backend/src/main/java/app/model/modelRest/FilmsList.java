package app.model.modelRest;

import org.springframework.data.domain.Page;

import app.model.Film;

public class FilmsList {
	
	private Page<Film> trending;
	private Page<Film> action;
	private Page<Film> adventure;
	private Page<Film> animation;
	private Page<Film> comedy;
	private Page<Film> drama;
	private Page<Film> horror;
	private Page<Film> scifi;
	

	public FilmsList() {

	}
	
	public FilmsList(Page<Film> trending2, Page<Film> action2, Page<Film> adventure2, Page<Film> animation2, Page<Film> comedy2, Page<Film> drama2, Page<Film> horror2, Page<Film> scifi2) {
		this.setTrending(trending2);
		this.setAction(action2);
		this.setAdventure(adventure2);
		this.setAnimation(animation2);
		this.setComedy(comedy2);
		this.setDrama(drama2);
		this.setHorror(horror2);
		this.setScifi(scifi2);
	}

	public Page<Film> getTrending() {
		return trending;
	}

	public Page<Film> getAction() {
		return action;
	}

	public Page<Film> getAdventure() {
		return adventure;
	}

	public Page<Film> getAnimation() {
		return animation;
	}

	public Page<Film> getComedy() {
		return comedy;
	}

	public Page<Film> getDrama() {
		return drama;
	}

	public Page<Film> getHorror() {
		return horror;
	}

	public Page<Film> getScifi() {
		return scifi;
	}


	public void setTrending(Page<Film> trending) {
		this.trending = trending;
	}

	public void setAction(Page<Film> action) {
		this.action = action;
	}

	public void setAdventure(Page<Film> adventure) {
		this.adventure = adventure;
	}

	public void setAnimation(Page<Film> animation) {
		this.animation = animation;
	}

	public void setComedy(Page<Film> comedy) {
		this.comedy = comedy;
	}

	public void setDrama(Page<Film> drama) {
		this.drama = drama;
	}

	public void setHorror(Page<Film> horror) {
		this.horror = horror;
	}

	public void setScifi(Page<Film> scifi) {
		this.scifi = scifi;
	}
}