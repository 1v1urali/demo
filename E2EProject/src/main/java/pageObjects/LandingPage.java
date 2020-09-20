package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;
public class LandingPage {
	
	public WebDriver driver;
		
	By email=By.xpath("/html/body/app-root/app-logged-out-shell/ng-component/fl-bit/fl-bit/app-form/form/app-title/fl-input/fl-bit/fl-bit/input");	
	By password=By.xpath("/html/body/app-root/app-logged-out-shell/ng-component/fl-bit/fl-bit/app-form/form/app-description/fl-bit[1]/fl-textarea/textarea");
	By login=By.xpath("/html/body/app-root/app-logged-out-shell/ng-component/fl-bit/fl-bit/app-form/fl-bit/fl-button/button");			
	By skills = By.xpath("//*[@id=\"skills\"]/fl-bit[3]/fl-multi-select/fl-bit/fl-bit/input");
		
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	public LandingPage(WebDriver driver) {		
		this.driver=driver;
	}

	public WebElement getEmail()
	{
		WebElement email_locator = driver.findElement(email);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'", email_locator);
		return email_locator;
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	
	public WebElement getSkills()
	{
		return driver.findElement(skills);
	}
}
