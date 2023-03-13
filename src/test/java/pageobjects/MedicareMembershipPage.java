package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicareMembershipPage {
	WebDriver mdriver;
	
	public MedicareMembershipPage(WebDriver driver)
	{
		mdriver=driver;
		PageFactory.initElements(mdriver, this);
	}
	
	@FindBy(id="firstName")
	WebElement firstname;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="contactNumber")
	WebElement contactNumber;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(name="_eventId_billing")
	WebElement billing;
	
	public void enterfirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	
	public void enterlastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void enteremail(String myemail)
	{
		email.sendKeys(myemail);
	}
	
	public void entercontactnumber(String number)
	{
		contactNumber.sendKeys(number);
	}
	
	public void enterpassword(String mypassword)
	{
		password.sendKeys(mypassword);
	}
	
	public void enterconfirmpassword(String mypassword)
	{
		confirmPassword.sendKeys(mypassword);
	}
	
	public void clickbilling()
	{
		billing.click();
	}
	
}

