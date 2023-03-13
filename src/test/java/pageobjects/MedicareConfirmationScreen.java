package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MedicareConfirmationScreen {

	WebDriver driver;
	
	public MedicareConfirmationScreen(WebDriver driver)
	{
		this.driver=driver;
		//PageFactory.initElements(cdriver, this);
	}
	
	/*
	 * @FindBy(xpath="//a[text()='Confirm']") public WebElement Confirm;
	 */
	
	
	public void clickConfirm()
	{
		try {
		     driver.findElement(By.linkText("Confirm")).click();
		  } catch (Exception e) {
		     JavascriptExecutor executor = (JavascriptExecutor) driver;
		     executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("Confirm")));
		  }
	}
}
