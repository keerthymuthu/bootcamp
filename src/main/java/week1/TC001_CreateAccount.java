package week1;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageomodel.LoginPage;

public class TC001_CreateAccount extends BaseClass{


	@BeforeTest 
	public void initValues() 
	{ dataSheetName="CreateAccount_TC001"; }


	@Test(dataProvider="fetchData")
	public void createAccount(String username, String password,String module,String name) throws InterruptedException {
		new LoginPage(driver).enterUserName(username).enterPassword(password).clickLogin()
		.clickAppLauncher().clickOnViewAll().searchAppLauncher(module).clickOnModule().clickOnAccounts().clickOnNew()
		.enterAccountName(name).clickOnOwnerShip().selectOwnerShip().clickSave().validateToastMessage().validateCreationName(name);
	}
}