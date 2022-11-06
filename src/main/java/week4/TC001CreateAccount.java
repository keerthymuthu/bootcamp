package week4;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjmodel.LoginPage;
import projectspecmethods.CommonMethods;

public class TC001CreateAccount extends CommonMethods{

	@BeforeTest 
	public void initValues() 
	{ dataSheetName="CreateAccount_TC001"; }
	
	@Test(dataProvider="fetchData")
	public void createAccount(String username, String password,String module,String name) throws InterruptedException {
		new LoginPage().enterUserName(username).enterPassword(password).clickOnLogin().clickOnAppLauncher()
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