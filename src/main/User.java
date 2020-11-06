package main;
import java.util.Date;

public class User extends Guest {
	
	private int id;
    private String userName;
    private String password;
    private boolean active;
    private String roles;
    private String email;
    
	public User(int id, String userName, String password, boolean active, String roles, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.active = active;
		this.roles = roles;
		this.email = email;
	}
	
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getEmail() { 
    	return email; 
    }

    public void setEmail(String email) { 
    	this.email = email; 
    }
	
	public boolean requestForm(Application a) {
		return false;
	}
	
	public Comment comment(String comment) {
		return new Comment(comment, userName);
	}
	
//	public Request submitRequest(String applicationName) {
//		
//		return new Request(applicationName, new Date().toString(), userName);
//	}

	

}
