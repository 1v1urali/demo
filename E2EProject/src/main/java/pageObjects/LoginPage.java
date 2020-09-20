package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import resources.base;
import com.paulhammant.ngwebdriver.NgWebDriver;

public class LoginPage {

	public WebDriver driver;
	public static NgWebDriver ngDriver;
	
	//Fields External WebSite Demo
	By postproject=By.xpath(".//*//a[contains(text(),' Post a Project ')]");
	
	//Fields for Gene Demo
	By username=By.xpath("<<Enter username xpath here>>");
	By password=By.xpath("");
	By loginbutton=By.xpath("");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;		
	}

	public LandingPage getLogin()
	{
		ngDriver = new NgWebDriver((JavascriptExecutor) driver);
		ngDriver.waitForAngularRequestsToFinish();
		
		
		/*
		 * driver.findElement(username).sendKeys("");
		 * driver.findElement(password).sendKeys("");
		 */
		
		
		//For External Website Demo
		driver.findElement(postproject).click();
		
		ngDriver.waitForAngularRequestsToFinish();		 
		
		LandingPage lp=new LandingPage(driver);
		return lp;	 
	}
	
	/*
	 * public WebElement getNavigationBar() { return driver.findElement(NavBar); }
	 * public WebElement getTitle() { return driver.findElement(title); }
	 */
}
