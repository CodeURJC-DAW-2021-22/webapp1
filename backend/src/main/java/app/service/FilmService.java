package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.model.Film;
import app.model.Genre;
import app.repository.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	private FilmRepository repository;
	
	public Optional<Film> findById(long id) {
		return repository.findById(id);
	}
	
	public List<Film> findByGenre(Genre similar){		
		return repository.findByGenre(similar);
	}
	
	public Page<Film> findByGenre(Genre genre, Pageable pageable){		
		return repository.findByGenre(genre, pageable);
	}
	
	public List<Film> findLikeName(String name) {
		return repository.findLikeName(name);
	}
	
	public List<Film> findLikeName(String name, Pageable pageable) {
		return repository.findLikeName(name, pageable);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<Film> findAll() {
		return repository.findAll();
	}
	
	public Page<Film> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public void save(Film film) {
		repository.save(film);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

	public long count() {
		return repository.count();
	}

	public long countByGenre(Genre genre) {
		return repository.countByGenre(genre);
	}

	public int countByName(String name) {
		return repository.countByName(name);
	}
}