package tests;

import main.User;
import main.Comment;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Application;

class CommentTest {

	@Test
	public void testUser() {
		User user = new User(1,"sam123", "password", true, "USER", "sam@gmail.com");
		
		assertEquals(1, user.getId());
		assertEquals("sam123", user.getUserName());
		assertEquals("password", user.getPassword());
		assertEquals(true, user.isActive());
		assertEquals("USER", user.getRoles());
		assertEquals("sam@gmail.com", user.getEmail());
		
	}
	
	@Test
	public void testComment() {
		
		Comment comment = new Comment("Hello World", "john321");
		
		assertEquals("Hello World", comment.getContents());
		assertEquals("john321", comment.getUsername());
		
	}
	
	@Test
	public void testCommentEdit() {
		
		Comment comment = new Comment("Hello World", "john321");
		comment.edit("This is a comment edit");
		
		assertEquals("This is a comment edit", comment.getContents());
		assertEquals("john321", comment.getUsername());
		
	}
	
	@Test
	public void testCommentUser() {
		User user = new User(1,"sam123", "password", true, "USER", "sam@gmail.com");
		
		Comment comment = user.comment("This user just commented");
		
		assertEquals("This user just commented", comment.getContents());
		assertEquals("sam123", user.getUserName());
		
	}

}
