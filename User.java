
public class User{
	 
	public String username;
	public String password;
	public int ID;

	
	public User() {
		this.username = "";
		this.password = "";
		this.ID = -1;
	}
	
	public User(String username, String password, int ID) {
		this.username = username;
		this.password = password;
		this.ID = ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	

}
