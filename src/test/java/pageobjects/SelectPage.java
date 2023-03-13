package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectPage {
	WebDriver driver;
	WebDriverWait wait;
	WebElement SelectAddress;
	
	public SelectPage(WebDriver driver)
	{
		this.driver=driver;
			
	}
	
	public void clickSelect()
	{
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[normalize-space()='Select']"))));
		SelectAddress=driver.findElement(By.xpath("//a[normalize-space()='Select']"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SelectAddress);
	}


}
