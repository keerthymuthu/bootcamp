package week1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteAccount extends BaseClass{

	
	@BeforeTest
	public void init() {
		dataSheetName="DeleteAccount";
	}
	
	@Test(dataProvider="fetchData")
	public void deleteAccount(String module,String input) throws InterruptedException {
		// TODO Auto-generated method stub
		//Search for Sales
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(module);
		//Click on Sales
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		//Click on Account
		WebElement account=driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();",account);
		//Search and select account
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(input);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//tbody/tr[1]/td[6]//a")).click();
		//Click on Edit button
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		//Confirm Delete
		WebElement confirmation=driver.findElement(By.xpath("//h2[text()='Delete Account']/following::span[text()='Delete']"));
		driver.executeScript("arguments[0].click();", confirmation);
		Thread.sleep(4000);
		//Final Validation
		driver.navigate().refresh();
		//Search and select account
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(input);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		boolean display=driver.findElement(By.xpath("//span[text()='No items to display.']")).isDisplayed();
		System.out.println("Display: "+display);
		Assert.assertEquals(display, true);
		System.out.println("Done !!");
	}
}