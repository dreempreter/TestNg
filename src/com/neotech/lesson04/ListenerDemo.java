package com.neotech.lesson04;


import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenerDemo {
	
@Test
public void test1()
{
	System.out.println("This is test1");
	Assert.assertTrue(true);
}

public void test2()
{
	System.out.println("This is test2");
	
	Assert.assertTrue(false);
}


}
