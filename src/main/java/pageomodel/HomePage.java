package pageomodel;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import week1.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage(RemoteWebDriver driver) {
		this.driver=driver;
		//this.properties=properties;
		//PageFactory.initElements(driver,this);
	}
	
	public HomePage clickAppLauncher() {
		//driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath(properties.getProperty("HomePage.appLauncher.xpath"))).click();
		return this;
	}
	
	public HomePage clickOnViewAll() {
		//driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath(properties.getProperty("HomePage.viewall.xpath"))).click();
		return this;
	}
	
	public HomePage searchAppLauncher(String module) {
		//driver.findElement(By.xpath("//input[@placeholder='Search apps or items...']")).sendKeys(module);
		driver.findElement(By.xpath(properties.getProperty("HomePage.searchAppLauncher.xpath"))).sendKeys(module);
		return this;
	}
	
	public SalesPage clickOnModule() {
		//driver.findElement(By.xpath("(//mark[text()='Sales'])[3]")).click();
		driver.findElement(By.xpath(properties.getProperty("HomePage.clickOnSalesModule.xpath"))).click();
		return new SalesPage(driver);
	}
	
	public ServiceConsole clickOnServiceConsoleModule() {
		//driver.findElement(By.xpath("//mark[text()='Service Console']")).click();
		driver.findElement(By.xpath(properties.getProperty("HomePage.clickOnServiceConsoleModule.xpath"))).click();
		return new ServiceConsole(driver,properties);
	}

}
