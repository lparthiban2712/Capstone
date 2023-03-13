package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	WebDriverWait wait;
	WebElement checkout;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void clickcheckout()
	{
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[normalize-space()='Checkout']"))));
		checkout=driver.findElement(By.xpath("//a[normalize-space()='Checkout']"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", checkout);
	}

	

}
