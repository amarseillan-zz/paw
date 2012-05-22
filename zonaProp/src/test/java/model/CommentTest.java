package model;

import org.junit.Test;

import zonaProp.transfer.bussiness.Comment;

public class CommentTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void userConstructorValidation(){
		String name = "somename";
		String email = "";
		String phone = "1223-1234";
		String desc = "something";
		
		Comment comment = new Comment(name, email, phone, desc);
		comment.getClass();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void userConstructorValidationEmail(){
		String name = "somename";
		String email = "";
		String phone = "1223-1234";
		String desc = "something";
		
		Comment comment = new Comment(name, email, phone, desc);
		comment.getClass();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void userConstructorValidationName(){
		String name = "nn";
		String email = "yourEmail";
		String phone = "1223-1234";
		String desc = "something";
		
		Comment comment = new Comment(name, email, phone, desc);
		comment.getClass();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void userConstructorValidationPhont(){
		String name = "name";
		String email = "yourEmail";
		String phone = "1223-12342323232323323";
		String desc = "something";
		
		Comment comment = new Comment(name, email, phone, desc);
		comment.getClass();
	}

}
