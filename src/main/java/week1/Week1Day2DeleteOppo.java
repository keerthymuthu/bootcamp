package week1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week1Day2DeleteOppo {

	@Test
	public void deleteOpportunity() throws InterruptedException {
		// TODO Auto-generated method stub
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
		//Search and click the Opportunity
		//driver.findElement(By.linkText("Salesforce Automation by Auto")).click();
		//Click on drop-down and edit
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Salesforce Automation by Auto");
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("((//span[@title='Opportunity Name']/following::a)[6]/following::td)[6]//a")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		//Confirm Delete
		WebElement confirmation=driver.findElement(By.xpath("//h2[text()='Delete Opportunity']/following::span[text()='Delete']"));
		driver.executeScript("arguments[0].click();", confirmation);
		//Final Validation
		driver.navigate().refresh();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Salesforce Automation by Auto");
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);
		boolean display=driver.findElement(By.xpath("//span[text()='No items to display.']")).isDisplayed();
		System.out.println("Display: "+display);
		Assert.assertEquals(display, true);
		System.out.println("Done !!");
	}
}
