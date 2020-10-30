package main;

public class Moderator extends User {
	
	public Moderator(String username, String password, String email) {
		super(username,password,email);
		this.username = username;
		this.password = password;
		this.email = email;
		this.ID = 1;
	}
	
	public boolean deleteComment(Comment c) {
		return false;
	}
	
	public boolean deleteApp(Application a) {
		return false;
	}

}
