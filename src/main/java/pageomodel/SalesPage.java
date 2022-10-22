package pageomodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import week1.BaseClass;

public class SalesPage extends BaseClass{
	
	public SalesPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	
	public AccountsPage clickOnAccounts() {
		//WebElement account=driver.findElement(By.xpath("//a[@title='Accounts']"));
		WebElement account=driver.findElement(By.xpath(properties.getProperty("AccountsPage.clickOnAccount.xpath")));
		driver.executeScript("arguments[0].click();",account);
		return new AccountsPage(driver);
	}
	
}
