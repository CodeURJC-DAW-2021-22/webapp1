package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.model.Genre;
import app.service.FilmService;

@RestController
@RequestMapping("/api/chart")
public class ChartController {
	
	@Autowired
	private FilmService filmService;
	
	@GetMapping("/")
	public List<Integer> calculateChart() {
		List<Integer> counters = new ArrayList<>();
		
		counters.add(filmService.countCommentsByGenre(Genre.ACTION));
		counters.add(filmService.countCommentsByGenre(Genre.ADVENTURE));
		counters.add(filmService.countCommentsByGenre(Genre.ANIMATION));
		counters.add(filmService.countCommentsByGenre(Genre.COMEDY));
		counters.add(filmService.countCommentsByGenre(Genre.DRAMA));
		counters.add(filmService.countCommentsByGenre(Genre.HORROR));
		counters.add(filmService.countCommentsByGenre(Genre.SCIENCE_FICTION));
		
		return counters;
	}
}