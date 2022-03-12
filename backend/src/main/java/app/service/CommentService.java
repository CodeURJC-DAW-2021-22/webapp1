package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.model.Comment;
import app.model.Film;
import app.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository repository;
	
	public Optional<Comment> findById(long id) {
		return repository.findById(id);
	}
	
	public void save(Comment comment) {
		repository.save(comment);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

	public long count() {
		return repository.count();
	}
	
	public List<Comment> findByFilm(Optional<Film> film, Pageable pageable){
		return repository.findByFilm(film, pageable);
	}

	public long countByFilm(Optional<Film> film) {
		return repository.countByFilm(film);
	}

	public List<Comment> findByFilm(Film film, Pageable pageable) {
		return repository.findByFilm(film, pageable);
	}
}