package com.neotech.lesson01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class TitleAndLoginValidation extends CommonMethods {
	@BeforeMethod
	public void openAndNavigate()
	{
		setUp();
	}
	
	@AfterMethod
	public void quitBrowser()
	{
		tearDown();
	}
	
	
	@Test
	public void  titleValidation() throws Exception
	{
		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle))
		{
			System.out.println("Title Validation Passed!");
		}
		else 
		{
			System.out.println("Title Validation Failed");
			throw new Exception();
		}
	
	
	wait(3);
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
