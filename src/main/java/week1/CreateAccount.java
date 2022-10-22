package week1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateAccount extends BaseClass{

	@BeforeTest
	public void initValues() {
		dataSheetName="CreateAccount";
	}

	@Test(dataProvider="fetchData")
	public void createAccount(String module,String input) throws InterruptedException, IOException {
		//Search for Sales
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(module); 
		//Click on Sales
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click(); 
		//Click on Account 
		WebElement account=driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();",account); //Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click(); 
		//Key in Account 
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(input);
		//Click on Ownership drop-down 
		driver.findElement(By.xpath("(//label[text()='Ownership']//following::button)[1]")).click();
		//Select Public 
		driver.findElement(By.xpath("//span[@title='Public']")).click();
		//Click on Save
		driver.findElement(By.xpath("//button[text()='Save']")).click(); 
		//Final validation 
		Thread.sleep(5000); 
		validationInput=input;
		output=driver.findElement(By.xpath("(//div[text()='Account']//following::lightning-formatted-text)[1]")).getText(); 
		System.out.println("Output: "+output); 
		//Assert.assertEquals(output,input);
	}
}