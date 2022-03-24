package app.modelRest;

import java.util.List;

import app.model.User;

public class ListFollowUser {
	private List<User> followers;
	private User user;
	private Boolean exist;
	
	public ListFollowUser() {
		
	}
	
	public ListFollowUser(List<User> followers, User user) {
		this.setFollowers(followers);
		this.setUser(user);
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getExist() {
		return exist;
	}

	public void setExist(Boolean exist) {
		this.exist = exist;
	}
}