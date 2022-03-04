package app.entity;


import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String title;
	@Column
	private String releaseDate;
	@Column
	private float averageStars;
	@Column
	private String minAge;
	@Column
	private Genre genre;
	@Column
	private String duration;
	@Column (name="casting")
	private String cast;
	@Column
	private String director;
	@Column
	private String plot;
	
	@OneToMany (mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments = new ArrayList<>();

	@Lob
	@JsonIgnore
	private Blob imageFile;

	@Column
	private boolean image;
	
	public Film() {
		
	}
	
    public Film(String title, String releaseDate, String minAge, String genre, String duration, String cast, String director, String plot) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.minAge = minAge;
        this.genre = Genre.valueOf(genre);
        this.duration = duration;
        this.cast = cast;
        this.director = director;
        this.plot = plot;
    }
    /*    
    public void deleteComment(Comment comment) {
		this.comments.remove(comment);
		comment.setFilm(null);
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

    public String getDuration() {
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
	
	public long getId() {
		return id;
	}
	
	public List<Comment> getComments() {
		return comments;
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

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setDuration(String duration) {
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

	public void setId(long newId) {
		this.id = newId;	
	}
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
}