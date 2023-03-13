package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MedicareLoginPage {
	
	
	WebDriver ldriver;
	
	public MedicareLoginPage(WebDriver driver)
	{
		ldriver=driver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath="//a[text()='Login']")
	WebElement userlogin;
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	
	public void clickuserlogin()
	{
		userlogin.click();
	}
	
	public void enterusername(String uname)
	{
		username.sendKeys(uname);
	}
	
	public void enterpassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickloginbutton()
	{
		login.click();
	}
	
	
	

}
