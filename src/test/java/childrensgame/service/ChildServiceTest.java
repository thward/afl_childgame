package childrensgame.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import childrensgame.service.impl.ChildServiceImpl;

public class ChildServiceTest {
	
	ChildService childService;

	
	@Before
	public void setUp() throws Exception {
		
		childService = new ChildServiceImpl();
	}

	// Exception is thrown when too few children
	@Test(expected = Exception.class) 
	public void testOneOne() {
		
		Assert.assertEquals(1, (int)childService.getWinner(1, 1));
	}
	
	// Exception is thrown when null children
	@Test(expected = Exception.class) 
	public void testNullOne() {
		
		Assert.assertEquals(1, (int)childService.getWinner(null, 1));
	}

	
	// Exception is thrown when elimination range too small
	@Test(expected = Exception.class) 
	public void testTwoZero() {
		
		Assert.assertEquals(1, (int)childService.getWinner(2, 0));
	}
	
	// Exception is thrown when elimination range is null
	@Test(expected = Exception.class) 
	public void testTwoNull() {
		
		Assert.assertEquals(1, (int)childService.getWinner(2, null));
	}


	
	@Test
	public void testFourTwo() {
		
		Assert.assertEquals(1, (int)childService.getWinner(4, 2));
	}
	

	@Test
	public void testThreeOne() {
		
		Assert.assertEquals(3, (int)childService.getWinner(3, 1));
	}

	
	@Test
	public void testThreeTwo() {
		
		Assert.assertEquals(2, (int)childService.getWinner(3, 2));
	}
	
	@Test
	public void testThreeThree() {
		
		Assert.assertEquals(2, (int)childService.getWinner(3, 3));
	}
	
	@Test
	public void testThreeFour() {
		
		Assert.assertEquals(1, (int)childService.getWinner(3, 4));
	}
	
	@Test
	public void testTwoOne() {
		
		Assert.assertEquals(1, (int)childService.getWinner(2, 1));
	}
	
	@Test
	public void testTwoTwo() {
		
		Assert.assertEquals(2, (int)childService.getWinner(2, 2));
	}
	
	@Test
	public void testTwoThree() {
		
		Assert.assertEquals(1, (int)childService.getWinner(2, 3));
	}

	
	

}
