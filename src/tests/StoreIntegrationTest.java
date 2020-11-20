package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Application;
import main.Store;

class StoreIntegrationTest {

	@Test
	void removeAppTest() {
		
		Store testStore = new Store();
		
		Application app1 = new Application("Facebook", "Connect with friends and family "
				+ "and meet new people on your social media network",
				"Facebook", "Apple", "294.0", "https://apps.apple.com/us/app/facebook/id284882215", 0);
		Application app2 = new Application("Snapchat", "Take a photo or video, add a caption, and send it "
				+ "to your best friends and family", "Snapchat", "Apple", "11.4.2.0", "https://apps.apple.com/us/app/snapchat/id447188370",
				0);
		Application app3 = new Application("Uber", "Open the app and enter where you'd want to go"
				+ ", and a nearby driver will help you get there.", "Uber", "Apple", "3.428.10001", "https://apps.apple.com/us/app/uber-request-a-ride/id368677368",
				0);
		
		testStore.appList.add(app1);
		testStore.appList.add(app2);
		testStore.appList.add(app3);
		
		testStore.appList.remove(2);
		
		assertEquals(app1, testStore.appList.get(0));
		assertEquals(app2, testStore.appList.get(1));
		
		testStore.appList.remove(0);
		
		assertEquals(app2, testStore.appList.get(0));
		
	}
	
	@Test
	void searchAppTest() {
		
		Store testStore = new Store();
		
		Application app1 = new Application("Facebook", "Connect with friends and family "
				+ "and meet new people on your social media network",
				"Facebook", "Apple", "294.0", "https://apps.apple.com/us/app/facebook/id284882215", 0);
		Application app2 = new Application("Snapchat", "Take a photo or video, add a caption, and send it "
				+ "to your best friends and family", "Snapchat", "Apple", "11.4.2.0", "https://apps.apple.com/us/app/snapchat/id447188370",
				0);
		Application app3 = new Application("Uber", "Open the app and enter where you'd want to go"
				+ ", and a nearby driver will help you get there.", "Uber", "Apple", "3.428.10001", "https://apps.apple.com/us/app/uber-request-a-ride/id368677368",
				0);
		
		testStore.appList.add(app1);
		testStore.appList.add(app2);
		testStore.appList.add(app3);
		
		assertEquals(true, testStore.search("Facebook"));
		assertEquals(true, testStore.search("Snapchat"));
		assertEquals(true, testStore.search("Uber"));
		assertEquals(false, testStore.search("Twitter"));
		
	}
	
	@Test
	void searchAppIndexTest() {
		
		Store testStore = new Store();
		
		Application app1 = new Application("Facebook", "Connect with friends and family "
				+ "and meet new people on your social media network",
				"Facebook", "Apple", "294.0", "https://apps.apple.com/us/app/facebook/id284882215", 0);
		Application app2 = new Application("Snapchat", "Take a photo or video, add a caption, and send it "
				+ "to your best friends and family", "Snapchat", "Apple", "11.4.2.0", "https://apps.apple.com/us/app/snapchat/id447188370",
				0);
		Application app3 = new Application("Uber", "Open the app and enter where you'd want to go"
				+ ", and a nearby driver will help you get there.", "Uber", "Apple", "3.428.10001", "https://apps.apple.com/us/app/uber-request-a-ride/id368677368",
				0);
		
		testStore.appList.add(app1);
		testStore.appList.add(app2);
		testStore.appList.add(app3);
		
		assertEquals(0, testStore.searchGetI("Facebook"));
		assertEquals(1, testStore.searchGetI("Snapchat"));
		assertEquals(2, testStore.searchGetI("Uber"));
		assertEquals(-1, testStore.searchGetI("Twitter"));
		
	}
	
	

}
