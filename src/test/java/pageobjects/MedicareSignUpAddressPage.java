package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicareSignUpAddressPage {
	WebDriver adriver;
	
	public MedicareSignUpAddressPage(WebDriver driver)
	{
		adriver=driver;
		PageFactory.initElements(adriver, this);
	}
	
	@FindBy(id="addressLineOne")
	WebElement addressLineOne;
	
	@FindBy(id="addressLineTwo")
	WebElement addressLineTwo;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="postalCode")
	WebElement postalCode;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(name="_eventId_confirm")
	WebElement _eventId_confirm;
	
	public void enteraddressLineOne(String addressLineone)
	{
		addressLineOne.sendKeys(addressLineone);
	}
	
	public void enteraddressLineTwo(String myaddressLineTwo)
	{
		addressLineTwo.sendKeys(myaddressLineTwo);
	}
	
	public void entercity(String mycity)
	{
		city.sendKeys(mycity);
	}
	public void enterpostalCode(String mypostalCode)
	{
		postalCode.sendKeys(mypostalCode);
	}
	
	public void enterstate(String mystate)
	{
		state.sendKeys(mystate);
	}
	
	public void entercountry(String mycountry)
	{
		country.sendKeys(mycountry);
	}
	
	public void clickconfirm()
	{
		_eventId_confirm.click();
	}
}
