package main;
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
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param the iD
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
	

}