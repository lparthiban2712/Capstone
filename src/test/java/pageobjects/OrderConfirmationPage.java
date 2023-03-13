package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	WebDriver driver;
	
	public OrderConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
		
	}
		
	@FindBy(xpath="//h3[text()='Your Order is Confirmed!!']")
	WebElement OrderConfirmation;

	public String getOrderConfirmation()
	{
		return OrderConfirmation.getText();
	}
	
	
	

}
