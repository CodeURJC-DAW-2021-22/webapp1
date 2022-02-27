package app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment {
	private int stars;
	private String note;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public Comment() {
		
	}

	public Comment(int stars, String note) {
        this.stars = stars;
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
}
