package app.model.modelRest;


import app.model.Comment;
import app.model.User;

public class UserComment {
	
	private User user;
	private Comment comment;

	public UserComment() {

	}
	
	public UserComment(User user, Comment comment) {
		this.user = user;
		this.comment = comment;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
}