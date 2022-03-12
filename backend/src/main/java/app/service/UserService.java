package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import app.model.User;
import app.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public Optional<User> findById(long id) {
		return repository.findById(id);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public void save(User user) {
		repository.save(user);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public Optional<User> findByName(String name){
		return repository.findByName(name);
	}

	public double countByFollowers(Optional<User> user) {
		return repository.countByFollowers(user);
	}

	public List<User> findByFollowers(Optional<User> user, Pageable pageable) {
		return repository.findByFollowers(user, pageable);
	}

	public List<User> findFollowers(User user, Pageable pageable) {
		return repository.findFollowers(user, pageable);
	}

	public List<User> findFollowing(User user, Pageable pageable) {
		return repository.findFollowing(user, pageable);
	}
}