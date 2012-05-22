package model;

import static org.junit.Assert.*;

import org.junit.Test;

import zonaProp.transfer.bussiness.Photo;
import zonaProp.transfer.bussiness.PrivatePerson;
import zonaProp.transfer.bussiness.RealEstate;

public class UserTest {
	
	@Test
	public void privatePersonEqualTest(){
		String email = "hola@gmail.com";
		String phone = "123-12345";
		String username = "usuario";
		String name = "name";
		String lastName = "lastame";
		String password = "123456";
		
		PrivatePerson userA = new PrivatePerson(name, lastName, email, phone, username, password);
		PrivatePerson userB = new PrivatePerson(name, lastName, email, phone, username, password);
		
		assertTrue(userA.equals(userB));
	}
	
	@Test
	public void privatePersonEqualTestFalseCase(){
		String email = "hola@gmail.com";
		String phone = "123-12345";
		String username = "usuario";
		String name = "name";
		String lastName = "lastame";
		String password = "123456";
		
		PrivatePerson userA = new PrivatePerson(name, lastName, email, phone, username, password);
		PrivatePerson userB = new PrivatePerson("anotherName", lastName, email, phone, username, password);
		
		assertFalse(userA.equals(userB));
	}

	@Test
	public void realEstateEqualTest(){
		String email = "hola@gmail.com";
		String phone = "123-12345";
		String username = "usuario";
		String companyName = "name";
		String password = "123456";
		Photo photo = new Photo();
		
		RealEstate userA = new RealEstate(companyName, photo, email, phone, username, password);
		RealEstate userB = new RealEstate(companyName, photo, email, phone, username, password);
		
		assertTrue(userA.equals(userB));
	}
	
	@Test
	public void realEstateEqualTestFalseCase(){
		String email = "hola@gmail.com";
		String phone = "123-12345";
		String username = "usuario";
		String companyName = "name";
		String password = "123456";
		Photo photo = new Photo();
		
		RealEstate userA = new RealEstate(companyName, photo, email, phone, username, password);
		RealEstate userB = new RealEstate("anotherCompany", photo, email, phone, username, password);
		
		assertFalse(userA.equals(userB));
	}

	@Test(expected = IllegalArgumentException.class)
	public void userConstructorValidation(){
		String email = "hola@gmail.com";
		String phone = "123-12345";
		String username = "usuario";
		String companyName = "name";
		String password = "12";
		Photo photo = new Photo();
		RealEstate user = new RealEstate(companyName, photo, email, phone, username, password);
		user.getClass();
	}
}
