package app.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.Film;
import app.model.Genre;
import app.service.FilmService;

@RestController
public class ChartController {
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping("/chart")
	public Collection<Integer> calculateChart() {
		List<Integer> counters = new ArrayList<>();
		List<Film> filmsAction = filmService.findByGenre(Genre.ACTION);
		List<Film> filmsAdventure = filmService.findByGenre(Genre.ADVENTURE);
		List<Film> filmsAnimation = filmService.findByGenre(Genre.ANIMATION);
		List<Film> filmsComedy = filmService.findByGenre(Genre.COMEDY);
		List<Film> filmsDrama = filmService.findByGenre(Genre.DRAMA);
		List<Film> filmsHorror = filmService.findByGenre(Genre.HORROR);
		List<Film> filmsScFiction = filmService.findByGenre(Genre.SCIENCE_FICTION);
		
		counters.add(getNumberComments(filmsAction));
		counters.add(getNumberComments(filmsAdventure));
		counters.add(getNumberComments(filmsAnimation));
		counters.add(getNumberComments(filmsComedy));
		counters.add(getNumberComments(filmsDrama));
		counters.add(getNumberComments(filmsHorror));
		counters.add(getNumberComments(filmsScFiction));
		
		return counters;
	}

	private int getNumberComments(List<Film> films) {
		int counter = 0;
		
		for (Film film : films) {
			counter += film.getComments().size();
		}
		
		return counter;
	}
}