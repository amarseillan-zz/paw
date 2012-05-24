package model;

import static org.junit.Assert.*;

import org.junit.Test;

import zonaProp.model.publication.ResultPage;

public class ResultPageTest {
		
		@Test
		public void pagesResultPageTest1(){
			ResultPage rp = new ResultPage(null, new Long(2), 30);
			assertEquals(rp.getPages(),1);
		}
		
		@Test
		public void pagesResultPageTest2(){
			ResultPage rp = new ResultPage(null, new Long(30), 30);
			assertEquals(rp.getPages(),1);
		}
		
		@Test
		public void pagesResultPageTest3(){
			ResultPage rp = new ResultPage(null, new Long(60), 30);
			assertEquals(rp.getPages(),2);
		}
		
		@Test
		public void pagesResultPageTest4(){
			ResultPage rp = new ResultPage(null, new Long(35), 30);
			assertEquals(rp.getPages(),2);
		}
}
