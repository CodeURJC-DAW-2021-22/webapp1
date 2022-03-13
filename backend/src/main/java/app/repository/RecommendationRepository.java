package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
	
}