package com.neotech.lesson04;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.ExcelUtility;

/*Open chrome browser
Go to "https://hrm.neotechacademy.com/"
Login to the application
Add 3 different Employees and Create Login Details by providing:
First Name
Last Name
Username
Password
Verify Employee has been added successfully and take screenshot 
(you must have 3 different screenshots)
Close the browser
Specify a group for this test case, add 
it into specific suite and execute from the xml file.*/
public class Homework1 extends CommonMethods {

		@Test(dataProvider = "excelData")
		public void test(String firstName, String lastName, String username, String password) {

			//login
			sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
			sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
			click(driver.findElement(By.xpath("//button[@type='submit']")));
			// Click on PIM menu
			driver.findElement(By.id("menu_pim_viewPimModule")).click();
			// Click on Add Employee
			driver.findElement(By.linkText("Add Employee")).click();

			wait(1);

			// Enter New Employee Data
			sendText(driver.findElement(By.id("first-name-box")), firstName);
			sendText(driver.findElement(By.id("last-name-box")), lastName);

			// Get empID for validation
			String empID = driver.findElement(By.id("employeeId")).getAttribute("value");
//Locate the
			WebElement dropdown=driver.findElement(By.id("location"));
			
			Select sel = new Select(dropdown);
			
			sel.selectByVisibleText("France Regional HQ");
			
			
			// Selenium click did not work, we use JavascriptExecutor
			jsClick(driver.findElement(By.id("hasLoginDetails")));
			
			wait(1);
			
			sendText(driver.findElement(By.id("username")), username);
			
			sendText(driver.findElement(By.id("password")), password);
			
			sendText(driver.findElement(By.id("confirmPassword")),password);
			
			wait(1);
			
			//click on save button
			
			click(driver.findElement(By.id("modal-save-button")));
			
			waitForVisibility(driver.findElement(By.id("pimPersonalDetailsForm")));
			
			//Validation
			
			String actualID=driver.findElement(By.id("employeeId")).getAttribute("vale");
			
			Assert.assertEquals(actualID, empID, "EmployeId's do NOT match!");
			
			//1 st way
		/*	TakesScreenshot ts = (TakesScreenshot) driver;
			
			File source= ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(source, new File("screenshot/" +firstName+ "-" + lastName+ ".png"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			*/
			
			//2nd way
			
			takeScreenshot(firstName + "_" + lastName);
			
			
		}

		@DataProvider(name="getData")
		public Object[][] createData() // Object means it can be any data type
		{
			Object[][] data = { 
					
					{ "Muradb", "Bayramovv", "ddreempreter", "Aamore2777$",},

					{ "Jamabla", "Gurbangova", "gurbanfova", "gusrban68",},

					{ "Enecs", "Sesrefsiz", "salish", "empiwre23",}
					
					
					

			};
			return data;
		}

		@DataProvider(name = "excelData")
		public Object[][] getExcelData() {
			return ExcelUtility.excelIntoArray(System.getProperty("user.dir") + "/testdata/Excel.xlsx", "Employee");
		}
}
