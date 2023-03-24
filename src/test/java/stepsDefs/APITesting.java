package stepsDefs;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITesting {
	WebDriver driver=Hooks.driver;
	List<WebElement> productresults;
	List<String> UIproductsList=new ArrayList<String>();
	List<String> JsonproductsList=new ArrayList<String>();
	List<String> ExpectedProductList=new ArrayList<String>();;
	
	@When("user selects {string} category in the UI")
	public void user_selects_category_in_the_ui(String Category) throws InterruptedException {
	    WebElement Categoryname=driver.findElement(By.xpath("//a[text()='"+Category+"']"));
	    Categoryname.click();
	    
	    productresults=driver.findElements(By.xpath("//table[@id='productListTable']//td[2]"));
	   
	    for(WebElement product:productresults)
	    {
	    	UIproductsList.add(product.getText());
	    }
	    	    
	}
	
	
	@And("user also sends the API call {string} to the products list under same category")
	public void user_also_sends_the_api_call_to_the_products_list_under_same_category(String url) {
	    RestAssured.baseURI=url;
	    RequestSpecification requestspecification=RestAssured.given();
	    Response response=requestspecification.request(Method.GET);
	    JsonPath path=response.jsonPath();
	    List<String> names= path.getList("name");
	    for(String name:names)
	    {
	    	JsonproductsList.add(name);
	    }
	}
	@Then("following products should be displayed in the results of UI and API JSON response")
	public void following_products_should_be_displayed_in_the_results_of_ui_and_api_json_response(DataTable data) {
		List<List<String>> ob=data.asLists();
		ExpectedProductList.add(ob.get(0).get(0));
		ExpectedProductList.add(ob.get(0).get(1));
		
		if((ExpectedProductList.equals(UIproductsList)) && (ExpectedProductList.equals(JsonproductsList)))
				{
 				Assert.assertTrue(true);
				}
		else 
		{
			Assert.assertTrue(false);
		}
	}
}
