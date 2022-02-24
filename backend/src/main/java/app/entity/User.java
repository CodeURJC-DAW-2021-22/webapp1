package app.entity;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private String encodedPassword;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	// Hay que tener cuidado con las peticiones de datos, lo mismo pueden acabar pidiendoselo circularmente
	//private List<Comment> comments;
	// Añadir atributo de imagen
	
	public User() {
		
	}

	public User(String name, String email, String password, String encodedPassword, String... roles) {
		this.name=name;
		this.email=email;
		this.password=password;
		this.encodedPassword=encodedPassword;
		this.roles=List.of(roles);
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
	
	public String getEncodedPassword() {
        return encodedPassword;
    }
	
	public List<String> getRoles() {
		return roles;
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

	public void setRoles(List<String> roles){
		this.roles = roles;
	}

	public void setEncodedPassword(String encodedPassword){
		this.encodedPassword = encodedPassword;
	}

}