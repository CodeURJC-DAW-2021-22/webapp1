package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	public List<Film> findByGenre(Genre similar) {		
		return repository.findByGenre(similar, Sort.by(Sort.Direction.DESC, "averageStars"));
	}
	
	public List<Film> findByGenreDistinct(Genre similar, long id) {
		return repository.findByGenreDistinct(similar, id, Sort.by(Sort.Direction.DESC, "averageStars"));
	}
	
	public List<Film> findByGenreDistinct(Genre similar, long id, Pageable pageable) {
		Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "averageStars"));
		return repository.findByGenreDistinct(similar, id, page);
	}
	
	public Page<Film> findByGenre(Genre genre, Pageable pageable) {
		Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "averageStars"));
		return repository.findByGenre(genre, page);
	}
	
	public List<Film> findLikeName(String name) {
		return repository.findLikeName(name, Sort.by(Sort.Direction.DESC, "averageStars"));
	}
	
	public List<Film> findLikeName(String name, Pageable pageable) {
		Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "averageStars"));
		return repository.findLikeName(name, page);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<Film> findAll() {
		return repository.findAll(Sort.by(Sort.Direction.DESC, "averageStars"));
	}
	
	public Page<Film> findAll(Pageable pageable) {
		Pageable page = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "averageStars"));
		return repository.findAll(page);
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