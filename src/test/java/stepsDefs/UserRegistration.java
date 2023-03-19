package stepsDefs;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.MedicareConfirmationScreen;
import pageobjects.MedicareHomePage;
import pageobjects.MedicareLoginPage;
import pageobjects.MedicareMembershipPage;
import pageobjects.MedicareSignUpAddressPage;
import pageobjects.MedicareWelcomePage;

public class UserRegistration {
	WebDriver driver=Hooks.driver;
		
	@Given("user click SignUp button")
	public void user_click_sign_up_button() {
		MedicareHomePage ur = new MedicareHomePage(driver);
		ur.clicksignup();
	   
	}

	 @When("^user enters basic information and navigates to Billing page$")
	    public void user_enters_basic_information_and_navigates_to_billing_page(DataTable data) throws Throwable {
		MedicareMembershipPage mp=new MedicareMembershipPage(driver);
		List<List<String>> ob=data.asLists();
		mp.enterfirstname(ob.get(0).get(0));
		mp.enterlastname(ob.get(0).get(1));
		mp.enteremail(ob.get(0).get(2));
		mp.entercontactnumber(ob.get(0).get(3));
		mp.enterpassword(ob.get(0).get(4));
		mp.enterconfirmpassword(ob.get(0).get(4));
		mp.clickbilling();
	}

	 @And("^user enters address information and navigates to confirmation screen$")
	    public void user_enters_address_information_and_navigates_to_confirmation_screen(DataTable data) throws Throwable {
		MedicareSignUpAddressPage ma=new MedicareSignUpAddressPage(driver);
		List<List<String>> ob=data.asLists();
		ma.enteraddressLineOne(ob.get(0).get(0));
		ma.enteraddressLineTwo(ob.get(0).get(1));
		ma.entercity(ob.get(0).get(2));
		ma.enterpostalCode(ob.get(0).get(3));
		ma.enterstate(ob.get(0).get(4));
		ma.entercountry(ob.get(0).get(5));
		ma.clickconfirm();
		
	}

	@And("user clicks confirm button")
	public void user_clicks_confirm_button() {
		MedicareConfirmationScreen cm=new MedicareConfirmationScreen(driver);
		cm.clickConfirm();
	}

	@And("user click Login Here button")
	public void user_click_login_here_button() {
		MedicareWelcomePage mc=new MedicareWelcomePage(driver);
		mc.clickLoginHere();
	}


    @And("^user enter username and password and clicks Login button$")
    public void user_enter_username_and_password_and_clicks_login_button(DataTable data) throws Throwable {
		MedicareLoginPage ml=new MedicareLoginPage(driver);
		List<List<String>> ob=data.asLists();
		
		ml.enterusername(ob.get(0).get(0));
		
		ml.enterpassword(ob.get(0).get(1));
		ml.clickloginbutton();
	}

	@Then("{string} page should be displayed")
	public void page_should_be_displayed(String home) {
	    String ExpectedResult=home;
		String ActualResult=driver.getTitle();
		Assert.assertEquals(ActualResult, ExpectedResult);
	}

}
