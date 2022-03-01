package app.advice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Film;
import app.entity.Genre;

public interface FilmRepository extends JpaRepository<Film, Long> {

	public List<Film> findByGenre(Genre similar);

	public Page<Film> findByGenre(Genre genre, Pageable pageable);
	
	public long count();
	
	public long countByGenre(Genre genre);
}