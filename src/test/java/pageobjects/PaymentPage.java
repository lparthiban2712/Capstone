package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	WebDriver driver;
	
	public PaymentPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
		
	}
		
	@FindBy(id="cardNumber")
	WebElement cardNumber;
	
	@FindBy(id="expityMonth")
	WebElement expityMonth;
	
	@FindBy(id="expityYear")
	WebElement expityYear;
	
	@FindBy(id="cvCode")
	WebElement cvCode;
	
	@FindBy(xpath="//a[normalize-space()='Pay']")
	WebElement Pay;
	
	
	
	public void entercardNumber(String cnumber)
	{
		cardNumber.sendKeys(cnumber);
	}
	
	public void enterexpityMonth(String expymonth)
	{
		cardNumber.sendKeys(expymonth);
	}
	
	public void enterexpityYear(String expyyear)
	{
		cardNumber.sendKeys(expyyear);
	}
	
	public void entercvCode(String cvc)
	{
		cardNumber.sendKeys(cvc);
	}
	
	public void clickPay()
	{
		Pay.click();
	}
	

}
