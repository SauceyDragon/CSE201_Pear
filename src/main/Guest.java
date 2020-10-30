package main;

public class Guest implements Person{

	public int ID = 0;
	
	@Override
	public int checkPrivillege() {
		return ID;
	}



}
