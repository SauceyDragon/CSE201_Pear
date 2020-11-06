package main;

public class Moderator {
	
	private int id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;
    private String email;
    
    public Moderator(int id, String userName, String password, boolean active, String roles, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.roles = roles;
		this.email = email;
	}
	
	
	public boolean deleteComment(Comment c) {
		return false;
	}
	
	public boolean deleteApp(Application a) {
		return false;
	}

}
