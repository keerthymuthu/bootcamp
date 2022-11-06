package pageobjmodel;

import org.openqa.selenium.WebElement;

import projectspecmethods.CommonMethods;

public class LoginPage extends CommonMethods{
	
	public LoginPage enterUserName(String username) {
		identifyElement("id", properties.getProperty("LoginPage.username.id")).sendKeys(username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		identifyElement("id", properties.getProperty("LoginPage.password.id")).sendKeys(password);
		return this;
	}
	
	public HomePage_hybrid clickOnLogin() {
		WebElement ele_login=identifyElement("id", properties.getProperty("LoginPage.LoginButton.id"));
		click(ele_login);
		return new HomePage_hybrid();
	}

}
