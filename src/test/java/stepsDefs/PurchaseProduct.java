package stepsDefs;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AddtoCartPage;
import pageobjects.CheckoutPage;
import pageobjects.MedicareProductsPage;
import pageobjects.OrderConfirmationPage;
import pageobjects.PaymentPage;
import pageobjects.SelectPage;

public class PurchaseProduct {
	WebDriver driver=Hooks.driver;
    
	 @When("^users clicks View button for Paracetamol$")
	    public void users_clicks_view_button_for_paracetamol() throws Throwable {
		 MedicareProductsPage mp=new MedicareProductsPage(driver);
		 mp.clickParacetamolview();
	    }


	    @And("^user clicks Add to Cart$")
	    public void user_clicks_add_to_cart() throws Throwable {
	    	AddtoCartPage ac=new AddtoCartPage(driver);
	    	ac.clickAddtoCart();
	    }

	    @And("^user clicks Checkout$")
	    public void user_clicks_checkout() throws Throwable {
	    	CheckoutPage cp=new CheckoutPage(driver);
	    	cp.clickcheckout();
	    	
	    }

	    @And("^user selects saved shippig address$")
	    public void user_selects_saved_shippig_address() throws Throwable {
	    	SelectPage sp=new SelectPage(driver);
	    	sp.clickSelect();
	    }

	    @And("user enters credit card informartion and click pay")
	    public void user_enters_credit_card_informartion_and_click_pay(DataTable data) {
	    	List<List<String>> ob=data.asLists();
	    	PaymentPage pp=new PaymentPage(driver);
	    	pp.entercardNumber(ob.get(0).get(0));
	    	pp.enterexpityMonth(ob.get(0).get(1));
	    	pp.enterexpityYear(ob.get(0).get(2));
	    	pp.entercvCode(ob.get(0).get(3));
	    	pp.clickPay();
	    	
	    }
	    

	    @Then("{string} message should be displayed")
	    public void message_should_be_displayed(String orderconfimration) throws Throwable  {
	    	
	    	String ExpectedResult=orderconfimration;
	    	OrderConfirmationPage oc=new OrderConfirmationPage(driver);
	    	String ActualResult=oc.getOrderConfirmation();
	    	Assert.assertEquals(ActualResult, ExpectedResult);
	    	
	    }

}
