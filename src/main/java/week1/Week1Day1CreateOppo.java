package week1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week1Day1CreateOppo {
	
	@Test
	public void createOpportunity() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		//Launch Salesforce
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		//Key in credentials
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("India$321");
		//click on login
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		//click on toggle
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Click on view All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Search for Sales
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("Sales");
		//Click on Sales
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		//Click on Opportunities
		WebElement opportunity=driver.findElement(By.xpath("(//span[@class='slds-truncate'])[3]")); 
		driver.executeScript("arguments[0].click();",opportunity);
		//Click on New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//Enter the Opportunity Name
		String name="Salesforce Automation by Auto";
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(name);
		//Select drop-down
		driver.findElement(By.xpath("(//div[@role='none'])[2]/button")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		//Click on Close Date
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[@name='today']")).click();
		//Click on Save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
		WebElement ele_toastspan=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]")));
		System.out.println("Toast Message: "+ele_toastspan.getText());
		String expected="Opportunity "+name+" was created";
		System.out.println("Expected Toast Message: "+expected);
		//assert ele_toastspan.getText()==expected;
		//Click on Opportunity
		String actual=driver.findElement(By.xpath("//slot[@name='primaryField']//lightning-formatted-text")).getText();
		//Verify the name
		Assert.assertEquals(actual, name);
		System.out.println("Done !!");
	}
}