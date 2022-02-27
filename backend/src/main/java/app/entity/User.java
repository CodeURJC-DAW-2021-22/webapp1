package app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name="Customer")
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String email;
	private String password;
	private String passwordConfirm;
	/*
	@OneToMany
	private List<Comment> comments = new ArrayList<>();
	*/
	// Hay que tener cuidado con las peticiones de datos, lo mismo pueden acabar pidiendoselo circularmente
	// Añadir atributo de imagen
	
	public User() {
		
	}
	public User(String name, String email, String password, String passwordConfirm) {
		this.name=name;
		this.email=email;
		this.password=password;
		this.passwordConfirm=passwordConfirm;
	}
	/*
	// Comments
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	public void deleteComment(Comment comment) {
		this.comments.remove(comment);
	}
	*/
	// Getters
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	

	
	public Long getId() {
		return id;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}