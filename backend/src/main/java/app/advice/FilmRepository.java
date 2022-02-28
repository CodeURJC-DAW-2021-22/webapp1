package app.advice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Film;
import app.entity.Genre;

public interface FilmRepository extends JpaRepository<Film, Long> {

	public List<Film> findByGenre(String genre);

	public Page<Film> findByGenre(String genre, Pageable pageable);
	
	public long count();
}