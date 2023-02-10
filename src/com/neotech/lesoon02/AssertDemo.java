package com.neotech.lesoon02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class AssertDemo extends CommonMethods{
	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}
	
	@Test(enabled=false)
	public void titleValidation()
	{
		String expectedTitle= "OrangeHRM...";
		String actualTitle= driver.getTitle();
		
		
		//1st way
		//Assert.assertEquals(actualTitle, expectedTitle);
		
		//2nd way it also prints meaningful message
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
		
		
		//If we are using hard assertion fails
		//The statements after the assertion will not be executed
		System.out.println("Contine after assertion...");
		
	}
	
	@Test
	public void validationLoge()
	{
		WebElement logo=driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));
		boolean logoDisplayed=logo.isDisplayed();
		
		//I am manually setting this variable to false, to fail the test
		logoDisplayed=false;
		//1st way
		//Assert.assertEquals(logoDisplayed, true);
		
		//2nd way
		//Assert.assertEquals(logoDisplayed, true, " Logo is NOT displayed");
		
		Assert.assertTrue(logoDisplayed, " Logo is NOT displayed ");
	}
	
	
	
	
	
	
	
	
	
	
	
}
