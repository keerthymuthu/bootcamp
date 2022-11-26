package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjectmodel.LoginPage_test;
import projectspecificmethods.CommonMethods_test;

public class TC003_DeleteAccount_test extends CommonMethods_test{

	@BeforeTest
	public void initValues() {
		dataSheetName="DeleteAccount_TC003";
	}

	@Test(dataProvider="fetchData")
	public void deleteAccount(String username,String password,String module,String name) throws InterruptedException {
		new LoginPage_test(driver,test)
		.enterUserName(username)
		.enterPassword(password)
		.clickOnLogin()
		.clickOnAppLauncher()
		.clickOnViewAll()
		.searchAppLauncher(module)
		.clickOnModule()
		.clickOnAccount()
		.searchAccount(name)
		.selectFromSearchResult()
		.clickonDelete()
		.clickConfirmDelete()
		.searchAccount(name)
		.validateSearchResult();
	}
}