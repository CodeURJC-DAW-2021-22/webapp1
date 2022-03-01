package app.advice;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

}