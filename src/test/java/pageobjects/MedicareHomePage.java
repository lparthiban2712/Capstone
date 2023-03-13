package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MedicareHomePage {

	WebDriver driver;
	public WebElement signup;
	public WebElement login;
	WebDriverWait wait;
	
	public MedicareHomePage(WebDriver driver)
	{
		this.driver=driver;
		
		
	}
	
	public void clicksignup()
	{
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Sign Up']"))));
		signup=driver.findElement(By.xpath("//a[text()='Sign Up']"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", signup);
	}
	
	public void clicklogin()
	{
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Login']"))));
		login=driver.findElement(By.xpath("//a[text()='Login']"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", login);
	}
}
