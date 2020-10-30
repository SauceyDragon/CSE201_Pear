package tests;

import main.Store;
import main.Application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StoreTest {
	
	Store testStore = new Store();

	@Test
	public void testConstructor() {
		
		Application app1 = new Application("Facebook", "Connect with friends and family "
				+ "and meet new people on your social media network",
				"Facebook", "Apple", "294.0", "https://apps.apple.com/us/app/facebook/id284882215", 0);
		testStore.appList.add(app1);
		assertEquals(app1,testStore.appList.get(0));
		
	}
	
	
	@Test
	public void testSort() {
		
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
		testStore.sort(0);
		
		assertEquals(3, testStore.appList.size());
		assertEquals(app1, testStore.appList.get(0));
		assertEquals(app2, testStore.appList.get(1));
		assertEquals(app3, testStore.appList.get(2));
		
	}
	
	@Test
	public void testSortBack() {
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
		testStore.sort(1);
		
		assertEquals(3, testStore.appList.size());
		assertEquals(app3, testStore.appList.get(0));
		assertEquals(app2, testStore.appList.get(1));
		assertEquals(app1, testStore.appList.get(2));
	}
	
	@Test
	public void testFilter() {
		Application app1 = new Application("Facebook", "Connect with friends and family "
				+ "and meet new people on your social media network",
				"Facebook", "Apple", "294.0", "https://apps.apple.com/us/app/facebook/id284882215", 4.99);
		Application app2 = new Application("Snapchat", "Take a photo or video, add a caption, and send it "
				+ "to your best friends and family", "Snapchat", "Apple", "11.4.2.0", "https://apps.apple.com/us/app/snapchat/id447188370",
				1.99);
		Application app3 = new Application("Uber", "Open the app and enter where you'd want to go"
				+ ", and a nearby driver will help you get there.", "Uber", "Apple", "3.428.10001", "https://apps.apple.com/us/app/uber-request-a-ride/id368677368",
				2.99);
		
		testStore.appList.add(app1);
		testStore.appList.add(app2);
		testStore.appList.add(app3);
		
		testStore.filter(3.5);
		
		assertEquals(app2, testStore.temp.get(0));
		assertEquals(app3, testStore.temp.get(1));
		
	}
	
	
}
