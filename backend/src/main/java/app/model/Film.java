package app.model;

import java.sql.Blob;
import java.sql.Date;
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

@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String title;
	private Date releaseDate;
	private int averageStars;
	private String minAge;
	private Genre genre;
	private int duration;
	
	@Column (name="casting")
	private String cast;
	
	private String director;
	private String plot;
	
	@OneToMany (mappedBy="film", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Comment> comments = new ArrayList<>();

	@Lob
	private Blob imageFile;

	private boolean image;
	
	public Film() {
		
	}
	
    public Film(String title, Date releaseDate, String minAge, String genre, int duration, String cast, String director, String plot) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.minAge = minAge;
        this.genre = Genre.valueOf(genre);
        this.duration = duration;
        this.cast = cast;
        this.director = director;
        this.plot = plot;
    }
	
    public void calculateAverage() {
    	if (comments.size() != 0) {
    		int sum = 0;
        	
        	for (Comment comment: comments) {
        		sum += comment.getStars();
        	}
        	
        	averageStars = Math.round(sum / comments.size());
    	}
    }
    
	// Getters
    public Long getId() {
    	return id;
    }
    
	public String getTitle() {
        return title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }
    
    public int getAverageStars() {
    	calculateAverage();
    	return averageStars;
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
		return image;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
    // Setters
	public void setId(Long id) {
		this.id = id;
	}
	
    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
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
	
	public void addComment(Comment comment) {
		comments.add(comment);
		comment.setFilm(this);
		calculateAverage();
	}
	
	public void deleteComment(Comment comment) {
		comments.remove(comment);
		comment.setFilm(null);
		calculateAverage();
	}
}