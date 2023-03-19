package pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCategory {
	WebDriver driver;
	WebElement CategoryName;
	WebElement categoryDescription;
	WebElement Save;
	WebDriverWait wait;
	
	
	public AddNewCategory(WebDriver driver)
	{
		this.driver=driver;
		//PageFactory.initElements(this.driver, this);
			
	}
	
	/*
	 * @FindBy(id="name") public WebElement enterCategoryName;
	 * 
	 * @FindBy(id="name") public WebElement enterCategoryDescription;
	 */
	
	
	  public void enterCategoryName(String cname) throws InterruptedException 
	  { 
	wait=new WebDriverWait(driver,20);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("name")))); 
	  CategoryName=driver.findElement(By.xpath("//form[@id='categoryForm']//input[@id='name']")); 
	  JavascriptExecutor executor=(JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].value='"+cname+"';", CategoryName);
	
	  
	  }
	  
	  public void entercategoryDescription(String cdesc) throws InterruptedException { wait=new WebDriverWait(driver,20);
	  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(
	  "description"))));
	  categoryDescription=driver.findElement(By.xpath("//form[@id='categoryForm']//textarea[@id='description']"));
	  JavascriptExecutor executor=(JavascriptExecutor)driver;
	  executor.executeScript("arguments[0].value='"+cdesc+"';", categoryDescription);
	  
	  
	  }
	 
	/*
	 * public void enterCategoryName(String name) { wait=new
	 * WebDriverWait(driver,20);
	 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("name")))
	 * ); enterCategoryName.sendKeys(name);
	 * 
	 * }
	 * 
	 * public void enterCategoryDescription(String description) { wait=new
	 * WebDriverWait(driver,20);
	 * wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(
	 * "description")))); enterCategoryName.sendKeys(description);
	 * 
	 * }
	 */
	
	public void clickSave()
	{
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@id='categoryForm']//input[@name='submit']"))));
		Save=driver.findElement(By.xpath("//form[@id='categoryForm']//input[@name='submit']"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Save);
		
	}
	

}
