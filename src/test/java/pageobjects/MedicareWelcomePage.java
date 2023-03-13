package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MedicareWelcomePage {

	WebDriver driver;
	
	public MedicareWelcomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public void clickLoginHere()
	{
		try {
			driver.findElement(By.linkText("Login Here")).click();
			
		}
		catch(Exception e)
		{
			JavascriptExecutor executor=(JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("Login Here")));
			
		}
	}
}
