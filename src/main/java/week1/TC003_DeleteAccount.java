package week1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageomodel.LoginPage;

public class TC003_DeleteAccount extends BaseClass{
	
	@BeforeTest
	public void initValues() {
		dataSheetName="DeleteAccount_TC003";
	}
	
	@Test(dataProvider="fetchData")
	public void deleteAccount(String username,String password,String module,String name) throws InterruptedException {
		new LoginPage(driver).enterUserName(username).enterPassword(password).clickLogin()
		.clickAppLauncher().clickOnViewAll().searchAppLauncher(module).clickOnModule().clickOnAccounts().searchAccount(name)
		.selectFromSearchResult();
	}

}
