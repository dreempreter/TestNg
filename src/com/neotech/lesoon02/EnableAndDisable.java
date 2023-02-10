package com.neotech.lesoon02;

import org.testng.annotations.Test;

public class EnableAndDisable {

	//@Test(enabled= false,priority=0) // enabled means you do not want to test it
	public void firstTest()
	{
		System.out.println(" First Test Method ");
	}

	@Test(enabled=false,priority=1)
	public void secondTest()
	{
		System.out.println(" Second Test Method ");
	}
	@Test(enabled=true,priority=2)
	public void thirdTest()
	{
		System.out.println(" Third Test Method ");
	}

	@Test(priority=10)
	public void fourthTest()
	{
		System.out.println(" Fourth Test Method ");
	}

	
	
	
	
	
	
	
	
	
	
	
}
