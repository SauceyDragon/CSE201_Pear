package main;

public class Administrator extends Moderator {
		
	public Administrator(String username, String password, String email) {
		super(username,password,email);
		this.username = username;
		this.password = password;
		this.email = email;
		this.ID = 2;
	
	}
	
	public boolean approveForm(Request r) {
		return false;
	}
	public boolean rejectForm(Request r) {
		return false;
		
	}
	

}
