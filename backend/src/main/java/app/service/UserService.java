package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<User> findFollowersById(long id, Pageable pageable) {
		return repository.findByFollowersId(id, pageable);
	}

	public List<User> findFollowingById(long id, Pageable pageable) {
		return repository.findByFollowingId(id, pageable);
	}
}