package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

import zonaProp.transfer.bussiness.Environment;
import zonaProp.transfer.bussiness.OperationType;
import zonaProp.transfer.bussiness.PropertyServices;
import zonaProp.transfer.bussiness.PropertyType;
import zonaProp.transfer.bussiness.Publication;


public class PublicationTest{
	
	@Test
	public void visitPublicationTest(){
		
		int publicationId=0;
		PropertyType propertyType = PropertyType.HOUSE;
		OperationType operationType = OperationType.RENT;
		String address = "Santa fe 1500";
		String city = "Capital Federal";
		double price = 50000;
		int environments = 5  ;
		double covered = 100;
		double uncovered = 100;
		int age = 30;
		List<PropertyServices> propertyServices = new ArrayList<PropertyServices>();
		String description = "description";
		boolean active = true;
		boolean reserved = false;
		List<Environment> environmentList = new ArrayList<Environment>();
		
		Publication publication = new Publication(publicationId, propertyType, operationType, address, city, price, environments, covered, uncovered, age, propertyServices, description, active, reserved, environmentList);

		assertEquals(publication.getAccess(), 0);
		
		publication.access();
		publication.access();
		
		assertEquals(publication.getAccess(), 2);
	
	}

}
