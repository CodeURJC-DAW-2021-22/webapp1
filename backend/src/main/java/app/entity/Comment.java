package app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//private User user;
	private int stars;
	private String note;
	
	@ManyToOne
	@JsonIgnore
	private Film film;
	
	@ManyToOne
	@JsonIgnore
	private User user;
	
	public Comment() {
		
	}
	
	public Comment(String stars, String note) {
        this.stars = Integer.parseInt(stars);
        this.note = note;
    }

	// Getters
    public int getStars() {
        return stars;
    }

    public String getNote() {
        return note;
    }
    
    public Film getFilm() {
        return film;
    }

    // Setters
    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setNote(String note) {
        this.note = note;
    }
    

	public void setFilm(Film film) {
		this.film = film;		
	}
	
	public void setUser(User user) {
		this.user = user;		
		user.addComment(this);
	}
    public void setComment(Comment comment) {
		this.stars = comment.getStars();
		this.note = comment.getNote();

	}
}
