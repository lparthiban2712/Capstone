package stepsDefs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.MedicareLoginPage;

public class Hooks {
	static WebDriver driver;
	String url;
	String emailid;
	String password;
	Properties prop;
	
	public Hooks() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//utilities//global.properties");
		prop=new Properties();
		prop.load(fis);
		url=prop.getProperty("url");
		emailid=prop.getProperty("emailid");
		password=prop.getProperty("password");
	}
	
	
	@Before("@Registration")
	public void setup1()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Before("@Functional")
	public void setup2()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		MedicareLoginPage ml=new MedicareLoginPage(driver);
		ml.clickuserlogin();
		ml.enterusername(emailid);
		ml.enterpassword(password);
		ml.clickloginbutton();

	}
	@After
	public void teardown()
	{
		driver.quit();
		prop.clear();
		
	}

}
