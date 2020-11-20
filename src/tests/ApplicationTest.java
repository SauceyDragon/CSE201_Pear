package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.Application;

class ApplicationTest {

	@Test
	void applicationTest() {
		
		Application app1 = new Application("Facebook", "Connect with friends and family "
				+ "and meet new people on your social media network",
				"Facebook", "Apple", "294.0", "https://apps.apple.com/us/app/facebook/id284882215", 0);
		
		assertEquals("Facebook", app1.getName());
		assertEquals("Connect with friends and family and meet new people on your social media network", app1.getDescription());
		assertEquals("Facebook", app1.getOrganization());
		assertEquals("Apple", app1.getPlatform());
		assertEquals("294.0", app1.getVersion());
		assertEquals("https://apps.apple.com/us/app/facebook/id284882215", app1.getLink());
		assertEquals(0, app1.getPrice());
		
	}
	
	@Test
	void appCommentBoardTest() {
		
		Application app1 = new Application("Facebook", "Connect with friends and family "
				+ "and meet new people on your social media network",
				"Facebook", "Apple", "294.0", "https://apps.apple.com/us/app/facebook/id284882215", 0);
		
		assertEquals("Facebook Comment Board", app1.getCommentList().getLast());
		assertEquals("Facebook Comment Board", app1.getCommentList().getFirst());
		
	}
	
	@Test
	void appCommentsTest() {
		
		Application app1 = new Application("Facebook", "Connect with friends and family "
				+ "and meet new people on your social media network",
				"Facebook", "Apple", "294.0", "https://apps.apple.com/us/app/facebook/id284882215", 0);
		
		app1.getCommentList().insertLast("I love this app!");
		app1.getCommentList().insertLast("I hate this app!");
		
		assertEquals("I hate this app!", app1.getCommentList().getLast());
		
		app1.getCommentList().removeLast();
		
		assertEquals("I love this app!", app1.getCommentList().getLast());
		
	}

}
