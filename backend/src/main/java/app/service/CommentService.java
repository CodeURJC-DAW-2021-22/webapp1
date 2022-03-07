package app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Comment;
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
}