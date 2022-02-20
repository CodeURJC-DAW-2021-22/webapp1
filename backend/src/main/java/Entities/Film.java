package Entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String releaseDate;
	// No sé si puede ser float o no
	private float averageStars;
	private int minAge;
	private Genre genre;
	private int duration;
	private ArrayList<String> cast;
	private String director;
	private String plot;
	
	private ArrayList<Comment> comments;
	// Añadir atributo de Imágenes
	
    public Film(String title, String releaseDate, int minAge, Genre genre, int duration, ArrayList<String> cast, String director, String plot) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.minAge = minAge;
        this.genre = genre;
        this.duration = duration;
        this.cast = cast;
        this.director = director;
        this.plot = plot;
    }
    
    // Comments
    public void addComment(Comment comment) {
    	this.comments.add(comment);
    	calculateAverage();
    }
    
    public void deleteComment(Comment comment) {
		this.comments.remove(comment);
		calculateAverage();
	}
    
    // Stars
    public void calculateAverage() {
    	int sum = 0;
    	for (Comment comment: comments) {
    		sum += comment.getStars();
    	}
    	this.averageStars = (sum/comments.size());
    }
    
	// Getters
	public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getMinAge() {
        return minAge;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public String getDirector() {
        return director;
    }

    public String getPlot() {
        return plot;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }
    
    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }
	
}