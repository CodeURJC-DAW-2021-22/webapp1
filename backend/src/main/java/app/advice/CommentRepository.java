package app.advice;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}