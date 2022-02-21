package app.advice;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.User;

public interface UsersRepository extends JpaRepository<User, Long> {

}