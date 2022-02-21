package app.advice;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}