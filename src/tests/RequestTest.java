package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.Administrator;
import main.Application;
import main.Request;
import main.User;

class RequestTest {

	@Test
	public void testRequest() {
		
		Request request = new Request();
	}
	
	
	@Test
	public void testApproveForm() {
		
		Administrator admin = new Administrator(1, "johnsmith", "password", true, "ADMIN", "johnsmith@gmail.com");
		
		Request request = new Request();
		
		assertEquals(true, admin.approveForm(request));
		
	}
	
	@Test
	public void testRejectForm() {
		
		Administrator admin = new Administrator(1, "johnsmith", "password", true, "ADMIN", "johnsmith@gmail.com");
		
		Request request = new Request();
		
		assertEquals(true, admin.rejectForm(request));
		
	}
	
	@Test
	public void testUserRequest() {
		
		User user = new User(1, "root", "password", true, "USER", "root@gmail.com");
		
		Application app1 = new Application("Facebook", "Connect with friends and family "
				+ "and meet new people on your social media network",
				"Facebook", "Apple", "294.0", "https://apps.apple.com/us/app/facebook/id284882215", 0);
		
		assertEquals(true, user.requestForm(app1));
		
	}
	
	
	

}
