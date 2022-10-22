package week2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCase {

	@Test
	public void deleteCase() throws InterruptedException {
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
		Thread.sleep(2000);
		//Click on Sales
		driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		Thread.sleep(3000);
		//Click on More
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
		WebElement ele_more=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='More']")));
		ele_more.click();
		Thread.sleep(4000);
		//Click on Cases
		WebElement ele_cases=driver.findElement(By.xpath("//span[@class='slds-truncate']/span[text()='Cases']"));
		driver.executeScript("arguments[0].click();", ele_cases);
		Thread.sleep(3000);
		//Fetch Case #
		String case_num=driver.findElement(By.xpath("//tbody//tr[1]//th//a")).getText();
		System.out.println("Case Number: "+case_num);
		//Click on Delete
		driver.findElement(By.xpath("//tbody//tr[1]//td[7]//a")).click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		//Confirm Delete
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		//Get Toast message
		WebElement ele_toastspan=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]")));
		System.out.println("Toast Message: "+ele_toastspan.getText());
		//Search for the case number
		WebElement search=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Search this list...']//following-sibling::div//input")));
		search.clear();
		search.sendKeys(case_num+Keys.ENTER);
		Thread.sleep(3000);
		assert true==driver.findElement(By.xpath("//span[text()='No items to display.']")).isDisplayed();
	}

}
