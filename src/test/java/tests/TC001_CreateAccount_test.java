package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjectmodel.LoginPage_test;
import projectspecificmethods.CommonMethods_test;

public class TC001_CreateAccount_test extends CommonMethods_test{
	@BeforeTest 
	public void initValues() 
	{
		testCaseName = "Account Creation";
		testDescription = "Create an Account";
		nodes = "Account";
		dataSheetName="CreateAccount_TC001"; 
	}
	
	@Test(dataProvider="fetchData")
	public void createAccount(String username, String password,String module,String name) throws InterruptedException {
		new LoginPage_test().enterUserName(username).enterPassword(password).clickOnLogin().clickOnAppLauncher()
		.clickOnViewAll()
		.searchAppLauncher(module)
		.clickOnModule()
		.clickOnAccount()
		.clickOnNew()
		.enterAccountName(name)
		.clickOnOwnerShip()
		.selectOwnerShip()
		.clickSave()
		.validateToastMessage()
		.validateCreationName(name);
	}
}
