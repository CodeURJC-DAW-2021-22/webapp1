package app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	//private User user;
	private int stars;
	private String note;
	@ManyToOne
	private Film film;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
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
}
