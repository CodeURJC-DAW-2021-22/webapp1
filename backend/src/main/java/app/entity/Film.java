package app.entity;


import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String releaseDate;
	private float averageStars;
	private String minAge;
	private Genre genre;
	private int duration;
	private String cast;
	private String director;
	private String plot;
	
	//private ArrayList<Comment> comments;

	@Lob
	private Blob imageFile;

	private boolean image;
	
	public Film() {
		
	}
	
    public Film(String title, String releaseDate, String minAge, String genre, String duration, String cast, String director, String plot) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.minAge = minAge;
        this.genre = Genre.valueOf(genre.toUpperCase());
        this.duration = Integer.parseInt(duration);
        this.cast = cast;
        this.director = director;
        this.plot = plot;
    }
    /*
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
    */
	// Getters
	public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getMinAge() {
        return minAge;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public String getCast() {
        return cast;
    }

    public String getDirector() {
        return director;
    }

    public String getPlot() {
        return plot;
    }
    
	public Blob getImageFile() {
		return imageFile;
	}
	
	public boolean getImage(){
		return this.image;
	}
	
    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    public void setGenre(String genre) {
        this.genre = Genre.valueOf(genre.toUpperCase());
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

	public void setImageFile(Blob image) {
		this.imageFile = image;
	}
	
	public void setImage(boolean image){
		this.image = image;
	}
	
}