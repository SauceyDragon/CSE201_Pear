package main;
import java.util.*;

public class Store {
	// List of Users
	public HashMap<String, String> userMap;
	// ArrayList of Applications
	public ArrayList<Application> appList;
	public ArrayList<Application> temp;
	
	public Store() {
		appList = new ArrayList<Application>();
		userMap = new HashMap<String, String>();
		temp = new ArrayList<Application>();
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
	

	
}
