package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

	double countByFollowers(Optional<User> user);

	List<User> findByFollowers(Optional<User> user, Pageable pageable);

	@Query("SELECT f from User u WHERE u IS user and f In u.followers")
	List<User> findFollowers(User user, Pageable pageable);

	// Aquí hay que meter la query correcta
	List<User> findFollowing(User user, Pageable pageable);
}