package com.neotech.lesson01;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

/*
 * Homework 1: HRMS Application Negative Login:
 * 
 * 1. Open chrome browser 2. Go to "https://hrm.neotechacademy.com/" 3. Enter
 * valid username 4. Leave password field empty 5. Verify error message with
 * text "Password cannot be empty" is displayed.
 */
public class Homework01 extends CommonMethods {

	@BeforeMethod
	public void negativeLogin() {
		setUp();
	}

	@AfterMethod
	public void quit() {
		tearDown();
	}

	@Test
	public void Login() throws Exception {
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), "");

		click(driver.findElement(By.xpath("//button[@type='submit']")));

		String expected = "Password cannot be empty";
		String actual = driver.findElement(By.id("txtPassword-error")).getText();

		if (expected.equals(actual)) {
			System.out.println(" The test passed");
		} else {
			System.out.println(" Test has failed, please try again");
			throw new Exception();
		}

		wait(3);
	}
}
