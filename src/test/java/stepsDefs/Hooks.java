package stepsDefs;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.MedicareLoginPage;

public class Hooks {
	static WebDriver driver;
	String url;
	String emailid;
	String password;
	Properties prop; 
	Connection con;
	Statement st;
	String query=" ";
	ResultSet result;
	String Categoryname;
	String Categorydescription;
	public Hooks() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//utilities//global.properties");
		prop = new Properties();
		prop.load(fis);
		url = prop.getProperty("url");
		emailid=prop.getProperty("emailid"); 
		password=prop.getProperty("password");
		Categoryname=prop.getProperty("newproductcategoryname");
		Categorydescription=prop.getProperty("newproductcategorydescription");
		  		
	}

	@Before("not @User")
	public void setup1() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	@Before("@User")
	public void setup2() 
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		MedicareLoginPage ml = new MedicareLoginPage(driver);
		ml.clickuserlogin();
		ml.enterusername(emailid);
		ml.enterpassword(password);
		ml.clickloginbutton();

	}


	@AfterStep
	public void attachscreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			byte[] source = screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(source, "image/png", "errorscreen");
		}
	}

	@After("@User")
	public void deleteuser() throws SQLException
	{
		String id="";
		boolean status=true;
		ArrayList<String>al=new ArrayList<String>();
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare","root" ,"admin"); 
		st=con.createStatement(); 
		query="select id,email from user_detail"; 
		result=st.executeQuery(query);
		while(result.next()) 
		{ 
			if(result.getString("email").equals(emailid))
			{
				id=String.valueOf(result.getInt("id"));
				System.out.println(id);
				break;
			}
		}
		query="Select id,user_id from order_detail";
		result=st.executeQuery(query);
		
		while(result.next()) 
		{ 
			if(String.valueOf(result.getString("user_id")).equals(id))
			{
				al.add(String.valueOf(result.getString("id")));
			}
			
		}
		System.out.println("list is "+al);
		for(String orderid:al)
		{
		System.out.println(orderid);
		query="delete from order_item where id="+orderid; 
		st.executeUpdate(query);
		}
		query="delete from order_detail where user_id="+id; 
		st.executeUpdate(query);
		query="delete from address where user_id="+id; 
		st.executeUpdate(query);
		query="delete from cart where user_id="+id;
		st.executeUpdate(query); 
		query="delete from user_detail where id="+id; 
		st.executeUpdate(query);
		query="select email from user_detail"; 
		ResultSet result2=st.executeQuery(query);
		while(result2.next()) 
		{ 
			if(result2.getString("email").equals(emailid))
			{
				status=false;
				break;
			}
		}
		
		if(status==false)
		{
			System.out.println("email id: "+emailid+" not deleted");
		}
		else
		{
			System.out.println("email id: "+emailid+" i deleted");
		}
	}
	
	@After("@Database")
	public void clearnewlyaddedcategory() throws SQLException
	{
		boolean status=true;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare","root","admin");
		st=con.createStatement();
		
		query="delete from category where description="+"'"+Categorydescription+"'";
		st.executeUpdate(query);
		query="select description from category";
		result=st.executeQuery(query);
		
		while(result.next())
		{
			
			if(result.getString("description").equals(Categorydescription))
			{
				status=false;
				break;
			}
		}
		if(status==false)
		{
			System.out.println("category is not deleted");
			
		}
		
		else
		{
			System.out.println("category is deleted");
		}
		
	}
	@After
	public void teardown() {
		driver.quit();
		prop.clear();

	}

}
