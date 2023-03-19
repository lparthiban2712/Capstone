package stepsDefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AddNewCategory;
import pageobjects.MedicareLoginPage;
import pageobjects.MedicareProductsPage;

public class AddingCategory {
	
	String Categoryname;
	String Categorydescription;
	WebDriver driver=Hooks.driver;
	boolean status=false;
	@Given("user logged in with admin username {string} and password {string}")
	public void user_logged_in_with_admin_username_and_password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		MedicareLoginPage ml = new MedicareLoginPage(driver);
		ml.clickuserlogin();
		ml.enterusername(string);
		ml.enterpassword(string2);
		ml.clickloginbutton();
	}
	@When("user click on Manage Product and selects Add New Category")
	public void user_click_on_manage_product_and_selects_add_new_category() throws InterruptedException {
		MedicareProductsPage mp=new MedicareProductsPage(driver);
		mp.clickManageProduct();
		mp.clickAddCategory();
		
	}
		
	@When("user provides Category name and description and saves it")
	public void user_provides_category_name_and_description_and_saves_it(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		List<List<String>> ob=dataTable.asLists();
		AddNewCategory ac=new AddNewCategory(driver);
		ac.enterCategoryName(ob.get(0).get(0));
		ac.entercategoryDescription(ob.get(0).get(1));
		ac.clickSave();
	   
	}
	
	@Then("verify category {string} and description {string} should be saved to database")
	public void verify_category_and_description_should_be_saved_to_database(String categoryname, String categorydesc) throws SQLException {
	    // Write code here that turns the phrase above into concrete actions
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare","root","admin");
		Statement st=con.createStatement();
		String query="select name,description from category";
		ResultSet result=st.executeQuery(query);
		
		while(result.next())
		{
			String category=result.getString("name");
			String description=result.getString("description");
			System.out.println("category is "+category+"  "+"description is "+description);
			
			if((category.equals(categoryname))&& (description.equals(categorydesc)))
			{
				status=true;
				break;
			}
		}
		
		if(status==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
	}

}
