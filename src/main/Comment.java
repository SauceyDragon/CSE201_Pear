package main;

public class Comment {
  
  private static int id = 0;
  public String contents;
  public String username;
  private final int COMMENT_LENGTH = 250;
  
  public Comment(String contents, String username) {
    
    if(contents.length() < COMMENT_LENGTH) {
    	Comment.id++;
    	this.contents = contents;
    	this.username = username;
    }

  }
  
  public String getContents() {
	  return contents;
  }
  
  public String getUsername() {
	  return username;
  }
  
  public boolean edit(String str) {
	  if(str.length() < COMMENT_LENGTH) {
		  contents = str;
		  return true;
	  }
	  else
		  return false;
  }
  
  public boolean delete() {
	  return false;
  }
  
  public boolean flag(int id) {
	  return false;
  }

}
