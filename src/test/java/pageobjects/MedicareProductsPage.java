package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MedicareProductsPage {
	WebDriver driver;
	WebElement ParacetamolView;
	WebElement ManageProduct;
	WebDriverWait wait;
	WebElement AddCategory;
	public MedicareProductsPage(WebDriver driver)
	{
		this.driver=driver;
			
	}
	public void clickParacetamolview()
	{
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h5[text()='Paracetamol']//following-sibling::div/a"))));
		ParacetamolView=driver.findElement(By.xpath("//h5[text()='Paracetamol']//following-sibling::div/a"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ParacetamolView);
		
	}
	
	public void clickManageProduct()
	{
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[normalize-space()='Manage Product']"))));
		ManageProduct=driver.findElement(By.xpath("//a[normalize-space()='Manage Product']"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ManageProduct);
		
	}
	
	public void clickAddCategory()
	{
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[normalize-space()='Add New Category']"))));
		AddCategory=driver.findElement(By.xpath("//button[normalize-space()='Add New Category']"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AddCategory);
		
	}
	

}
