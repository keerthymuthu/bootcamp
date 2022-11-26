package pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;

import projectspecificmethods.CommonMethods_test;

public class LoginPage_test extends CommonMethods_test{
	
	public LoginPage_test(ChromeDriver driver,ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public LoginPage_test enterUserName(String username) {
		identifyElement("id", properties.getProperty("LoginPage.username.id")).sendKeys(username);
		return this;
	}
	
	public LoginPage_test enterPassword(String password) {
		identifyElement("id", properties.getProperty("LoginPage.password.id")).sendKeys(password);
		return this;
	}
	
	public HomePage_test clickOnLogin() {
		WebElement ele_login=identifyElement("id", properties.getProperty("LoginPage.LoginButton.id"));
		click(ele_login);
		return new HomePage_test(driver,test);
	}
}
