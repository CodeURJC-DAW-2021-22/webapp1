package app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.model.Film;
import app.model.Genre;

public interface FilmRepository extends JpaRepository<Film, Long> {

	public List<Film> findByGenre(Genre similar, Sort sort);
	
	@Query("SELECT f from Film f WHERE f.genre = :similar AND f.id != :id")
	public List<Film> findByGenreDistinct(Genre similar, long id, Sort sort);

	public Page<Film> findByGenre(Genre genre, Pageable pageable);
	
	public long count();
	
	public long countByGenre(Genre genre);
	
	@Query("SELECT f from Film f WHERE LOWER(f.title) LIKE %:name%")
	public List<Film> findLikeName(String name, Sort sort);

	@Query("SELECT f from Film f WHERE LOWER(f.title) LIKE %:name%")
	public List<Film> findLikeName(String name, Pageable pageable);

	@Query("SELECT count(f) from Film f WHERE LOWER(f.title) LIKE %:name%")
	public int countByName(String name);
}