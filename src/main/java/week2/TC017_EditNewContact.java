package week2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC017_EditNewContact {
	
	@Test
	public void editNewContact() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement elementUsername=driver.findElement(By.id("username"));
		elementUsername.sendKeys("hari.radhakrishnan@qeagle.com");
		WebElement elementPassword=driver.findElement(By.id("password"));
		elementPassword.sendKeys("India$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys("contacts");
		driver.findElement(By.xpath("//mark[text()='Contacts']")).click();
		Thread.sleep(6000);
		
		//WebElement contact=driver.findElement(By.xpath("//table/thead/tr/th[3]/div/a/span[2]"));
		//JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		//executor3.executeScript("arguments[0].click();", contact);
		/* List<WebElement> tableRow = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));

		    for (int row = 0; row < tableRow.size(); row++) {

		        WebElement colData = tableRow.get(row);

		        List<WebElement> tableCol = colData.findElements(By.tagName("td"));

		        for (int col = 0; col < tableCol.size(); col++) {
		            String result = tableCol.get(col).getText();
		        }
		    }*/
		//Print contacts begins here
		JavascriptExecutor js=driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4000));
		//List<WebElement> ele_contacts=driver.findElements(By.xpath("//tbody/tr//th[1]//child::a[@data-refid='recordId']"));
		List<WebElement> ele=wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//tbody/tr//th[1]//child::a[@data-refid='recordId']"))));
		//List<WebElement> ele_contacts=driver.findElements(By.xpath("//tbody/tr//th[1]//child::a[@data-refid='recordId']"));
		System.out.println("Size of Contacts:"+ele.size());
		System.out.println("--------Contact Names-----------");
		for(WebElement ele_web:ele) {
			//System.out.println(ele.getAttribute("title"));
			System.out.println(ele_web.getText());
		}
		//Print contacts ends here
		
		/*
		//Final steps below	
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Vaishnavi"+Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table/tbody/tr/td[8]/span/div/a")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		Thread.sleep(3000);
        driver.findElement(By.xpath("//label[text()='Title']/following::input[1]")).sendKeys("Test");
        driver.findElement(By.xpath("//label[text()='Birthdate']/following::input[1]")).sendKeys("10/9/1985");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='--None--']")).click();
        driver.findElement(By.xpath("//span[@title='Purchased List']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[text()='Phone']/following::input[1]")).sendKeys("1234567890");
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        
        boolean phno = driver.findElement(By.xpath("//span[@class='forceOutputPhone slds-truncate']")).isEnabled();
		System.out.println(phno);

		if(phno=true)
		  {
			System.out.println("Contact is Edited");  
		  }
		  else {
			  System.out.println("Contact is not edited");
		  }
		
		*/
		
	}
}