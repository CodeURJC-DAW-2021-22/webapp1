package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Comment;
import app.model.Film;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	public long count();

	public List<Comment> findByFilm(Optional<Film> film, Pageable pageable);

	public List<Comment> findByFilm(Film film, Pageable pageable);

	public long countByFilm(Optional<Film> film);

}