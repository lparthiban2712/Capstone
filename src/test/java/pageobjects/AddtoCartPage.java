package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCartPage {
	WebDriver driver;
	WebElement AddtoCart;
	WebDriverWait wait;
	
	public AddtoCartPage(WebDriver driver)
	{
		this.driver=driver;
		
	}

	public void clickAddtoCart()
	{
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[normalize-space()='Add to Cart']"))));
		AddtoCart=driver.findElement(By.xpath("//a[normalize-space()='Add to Cart']"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AddtoCart);
	}
	
	
	

}
