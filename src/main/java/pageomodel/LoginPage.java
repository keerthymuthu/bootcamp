package pageomodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import week1.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage(RemoteWebDriver driver) {
		this.driver=driver;
		//this.properties=properties;
		//PageFactory.initElements(driver,this);
	}
	
	@FindBy(how=How.ID,using="username")
	public WebElement eleUserName;
	
	@FindBy(how=How.ID,using="password")
	public WebElement elePassword;
	
	@FindBy(how=How.ID,using="Login")
	public WebElement eleloginbutton;
	
	public LoginPage enterUserName(String username) {
		//type(eleUserName,username);
		System.out.println("App Url: "+properties.getProperty("appUrl"));
		//driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id(properties.getProperty("LoginPage.username.id"))).sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		//driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id(properties.getProperty("LoginPage.password.id"))).sendKeys(password);
		return this;
	}
	
	public HomePage clickLogin() {
		//driver.findElement(By.id("Login")).click();
		driver.findElement(By.id(properties.getProperty("LoginPage.LoginButton.id"))).click();
		return new HomePage(driver);
	}
	
	public HomePage launchApp() {
		return enterUserName("hari.radhakrishnan@qeagle.com").enterPassword("India$321").clickLogin(); 
	}
}