package main;

public class Request {
	
	static int id = 0;
	String appName;
	String requestTimestamp;
	String userSubmission;
	
	public Request() {
		
	}
	
	public Request(String appName, String requestTimestamp, String userSubmission) {
		super();
		id++;
		this.appName = appName;
		this.requestTimestamp = requestTimestamp;
		this.userSubmission = userSubmission;
	}
	
	
	

}
