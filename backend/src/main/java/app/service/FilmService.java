package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.advice.FilmRepository;
import app.entity.Film;
import app.entity.Genre;

@Service
public class FilmService {
	
	@Autowired
	private FilmRepository repository;
	
	public Optional<Film> findById(long id) {
		return repository.findById(id);
	}
	
	public List<Film> findByGenre(Genre genre){		
		return repository.findByGenre(genre);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<Film> findAll() {
		return repository.findAll();
	}

	public void save(Film film) {
		repository.save(film);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
	
}