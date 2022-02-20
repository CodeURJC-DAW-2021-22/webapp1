package Entities;

import javax.persistence.Entity;

@Entity
public class Comment {
	private int stars;
	private Customer user;
	private String note;
	
	public Comment(int stars, Customer user, String note) {
        this.stars = stars;
        this.user = user;
        this.note = note;
    }

	// Getters
    public int getStars() {
        return stars;
    }

    public Customer getUser() {
        return user;
    }

    public String getNote() {
        return note;
    }

    // Setters
    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
