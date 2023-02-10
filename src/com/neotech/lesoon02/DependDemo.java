package com.neotech.lesoon02;

import org.testng.annotations.Test;

public class DependDemo {
	
	@Test
	public void firstTest()
	{
		System.out.println(" First Test Method ");
	}

	@Test
	public void secondTest()
	{
		System.out.println(" Second Test Method ");
	}
	@Test(enabled= false,dependsOnMethods= {"firstTest", "secondTest"})
	public void thirdTest() throws Exception
	{
		System.out.println(" Third Test Method ");
		throw new Exception(); //We are failing this test on purpose
	}

	@Test(dependsOnMethods="thirdTest")
	public void fourthTest()
	{
		System.out.println(" Fourth Test Method ");
	}
}
