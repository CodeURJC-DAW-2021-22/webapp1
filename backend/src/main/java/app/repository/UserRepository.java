package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String name);
	
	List<User> findByFollowersId(long id, Pageable pageable);

	List<User> findByFollowingId(long id, Pageable pageable);
}