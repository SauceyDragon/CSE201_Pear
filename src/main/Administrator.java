package main;

public class Administrator {
	
	private int id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;
    private String email;
	
	public Administrator(int id, String userName, String password, boolean active, String roles, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.roles = roles;
		this.email = email;
	}
	
	public boolean approveForm(Request request) {
		return false;
	}
	public boolean rejectForm(Request request) {
		return false;
		
	}
	

}
