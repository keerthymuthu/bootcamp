package week1;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Week1Day2EditOppo {

	@Test
	public void editOpportunity() throws InterruptedException {
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
		Thread.sleep(2000);
		driver.findElement(By.xpath("((//span[@title='Opportunity Name']/following::a)[6]/following::td)[6]//a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		//Click on CloseDate
		Calendar calendar=new GregorianCalendar();
		calendar.add(Calendar.DATE, 1);
		System.out.println(new SimpleDateFormat("MM/dd/yyy").format(calendar.getTime()));
		WebElement selectClosedate = driver.findElement(By.xpath("//input[@name='CloseDate']")); 
		selectClosedate.clear(); 
		selectClosedate.sendKeys(new SimpleDateFormat("MM/dd/yyy").format(calendar.getTime()));
		//Click on Stage and select Perception Analysis
		//driver.findElement(By.xpath("(//div[@role='none'])[2]/button")).click();
		WebElement stage=driver.findElement(By.xpath("(//label[text()='Stage']/following::button)[1]"));
		driver.executeScript("arguments[0].click();", stage);
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
		//Click on Delivery/Installation Status
		WebElement deliverStatus=driver.findElement(By.xpath("(//label[text()='Delivery/Installation Status']/following::button)[1]"));
		driver.executeScript("arguments[0].click();", deliverStatus);
		driver.findElement(By.xpath("//span[@title='In progress']")).click();
		//Enter Description as Salesforce
		driver.findElement(By.xpath("//label[text()='Description']/following::div//textarea")).sendKeys("SalesForce");
		//Click on Save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//Assertion
		String finalStage=driver.findElement(By.xpath("//a[text()='Salesforce Automation by Auto']/following::span[text()='Perception Analysis']")).getText();
		Assert.assertEquals(finalStage, "Perception Analysis");
		System.out.println("Done !!");	
	}
}