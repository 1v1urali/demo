package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;

import pageObjects.ForgotPassword;
import pageObjects.LoginPage;
import pageObjects.LandingPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	public static NgWebDriver ngDriver;
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password,String text) throws IOException
	{
		//creating object to that class and invoke methods of it
		
		driver.get(prop.getProperty("url"));
		LoginPage l=new LoginPage(driver);
		
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		ngDriver.waitForAngularRequestsToFinish();
		
		LandingPage lp=l.getLogin();		
		lp.getEmail().click();		
		ngDriver.waitForAngularRequestsToFinish();	
				
		lp.getEmail().sendKeys("MyFirstDemo On Angular JS");				
		lp.getPassword().sendKeys("Entering 30 characters to test for the application");				
		lp.getLogin().click();
		ngDriver.waitForAngularRequestsToFinish();
		
		lp.getSkills().sendKeys("Quality Assurance And Management");
	}

	@AfterTest
	public void teardown()
	{		
		driver.close();		
	}

	@DataProvider
	public Object[][] getData()
	{		
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="maker@tcs.com";
		data[0][1]="457837";
		data[0][2]="Restrcited User";
		//1st row
		data[1][0]="checker@tcs.com";
		data[1][1]="457837";
		data[1][2]= "Non restricted user";
		
		return data;		
	}
	
}
