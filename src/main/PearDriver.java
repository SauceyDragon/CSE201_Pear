package main;
import java.util.ArrayList;

/*
 * Driver for the PearStore
 * 
 * Copyright Austin_Davis 2020
 */

public class PearDriver extends Store {

	public static void main(String[] args) {
		Store pear = new Store();
		
		pear.appList.add(new Application("twitter", "A social media app for messages" , "twitter.co", "iphone", "2.0", "twittee.com", 0.99));
		pear.appList.add(new Application("reddit", "A formum site" , "reddit", "windows", "1.6", "reddit.com", 1.95));
		pear.appList.add(new Application("insta", "A social media app for photos" , "facebook", "iphone", "1.0", "instagram.com", 2.99)); 
		
		System.out.println("unsorted");
		display(pear, pear.appList);
		//pear.view(pear.appList.get(0));
		//pear.view(pear.appList.get(1));
		//pear.view(pear.appList.get(2));
		
		pear.sort(0);
		
		System.out.println("sorted");
		display(pear, pear.appList);
		//pear.view(pear.appList.get(0));
		//pear.view(pear.appList.get(1));
		//pear.view(pear.appList.get(2));
		
        pear.sort(1);
		
		System.out.println("sorted back");
		display(pear, pear.appList);
		//pear.view(pear.appList.get(0));
		//pear.view(pear.appList.get(1));
		//pear.view(pear.appList.get(2));
		
		pear.filter(2);
		System.out.println("Filtered");
		display(pear, pear.temp);
		//pear.view(pear.appList.get(0));
		//pear.view(pear.appList.get(1));

		
	}
	private static void display(Store s,ArrayList<Application> arrList) {
		for(int i = 0; i < arrList.size(); i++) {
			s.view(s.appList.get(i));
		}
	}
	
	private void login() {
		
	}
	
	private void createUser() {
		
	}

}
