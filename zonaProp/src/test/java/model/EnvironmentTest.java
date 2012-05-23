package model;

import static org.junit.Assert.*;

import org.junit.Test;

import zonaProp.model.publication.Environment;
import zonaProp.model.publication.EnvironmentType;

public class EnvironmentTest {
	
	@Test
	public void environmentEqualTest(){
		
		EnvironmentType type = EnvironmentType.KITCHEN;
		int width = 10;
		int depth = 30;
		
		Environment environmentA = new Environment(0, type, width, depth);
		Environment environmentB = new Environment(0, type, width, depth);
		
		assertTrue(environmentA.equals(environmentB));
	}
	
	@Test
	public void environmentEqualTestFalseCase(){
		
		EnvironmentType type = EnvironmentType.KITCHEN;
		int width = 10;
		int depth = 30;
		
		Environment environmentA = new Environment(0, type, width, depth);
		Environment environmentB = new Environment(0, type, 45, depth);
		
		assertFalse(environmentA.equals(environmentB));
	}

}
