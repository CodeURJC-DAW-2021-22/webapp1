package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.model.Recommendation;
import app.repository.RecommendationRepository;

@Service
public class RecommendationService {
	
	@Autowired
	private RecommendationRepository repository;
	
	public List<Recommendation> findByUser(long id, Pageable pageable) {
		return repository.findRecommendationsByUser(id, pageable);
	}
	
	public void save(Recommendation recommendation) {
		repository.save(recommendation);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public int countByUser(long id) {
		return repository.findRecommendationsByUser(id).size();
	}
}