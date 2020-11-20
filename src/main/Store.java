package main;

import java.util.*;

public class Store {
	// List of Users
	public HashMap<String, User> userMap;
	// ArrayList of Applications
	public ArrayList<Application> appList;
	public ArrayList<Application> reqList;
	public ArrayList<Application> temp;
	
	public Store(){
		appList = new ArrayList<Application>();
		reqList = new ArrayList<Application>();
		userMap = new HashMap<String, User>();
		temp = new ArrayList<Application>();
		User ard = new User("Saucey", "Dragon", 3);
		User not = new User("", "", -1);
		User invaild = new User("Invaild", "Invaild", -1);
		userMap.put("Saucey?Dragon", ard);
		userMap.put("?", not);
		userMap.put("Invaild?Invaild", invaild);
	}

	public boolean view(Application a) {
		System.out.println("******************");
		System.out.println(a.getName());
		System.out.println(a.getDescription());
		System.out.println(a.getOrganization());
		System.out.println(a.getPlatform());
		System.out.println(a.getVersion());
		System.out.println(a.getLink());
		System.out.println(a.getPrice());
		System.out.println("******************");
		System.out.println();
		return true;
	}


	public void sort(int num) {
		if(num == 0)
			Collections.sort(appList, new Sortbyname());
		else if(num == 1)
			Collections.sort(appList, new Sortbynameback());
	}
	
	class Sortbyname implements Comparator<Application>{ 
		@Override
		public int compare(Application o1, Application o2) {
			return o1.getName().compareTo(o2.getName()); 
		}
	}
	class Sortbynameback implements Comparator<Application>{ 
		@Override
		public int compare(Application o1, Application o2) {

			return o2.getName().compareTo(o1.getName()); 
		}
	}

	public void filter(double price) {
		for(int i = 0; i < appList.size(); i++) {
			if(appList.get(i).getPrice() <= price)
				temp.add(appList.get(i));
		}
	}
	public boolean search(String s) {
		for(int i = 0; i < appList.size(); i++) {
			if(appList.get(i).getName().equals(s))
				return true;
		}
		return false;
	}
	public int searchGetI(String s) {
		for(int i = 0; i < appList.size(); i++) {
			if(appList.get(i).getName().equals(s))
				return i;
		}
		return -1;
	}
	
	

	
}