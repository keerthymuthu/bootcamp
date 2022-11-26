package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjectmodel.LoginPage_test;
import projectspecificmethods.CommonMethods_test;

public class TC007_CreateCase_test extends CommonMethods_test{
	@BeforeTest
	public void initValues() {
		dataSheetName="CreateCase_TC001";
	}
	
	@Test(dataProvider="fetchData")
	public void createCase(String username,String password,String module,String option,String status,String subject,String description,String output) throws InterruptedException {
		new LoginPage_test(driver,test)
		.enterUserName(username)
		.enterPassword(password)
		.clickOnLogin()
		.clickOnAppLauncher()
		.clickOnViewAll()
		.searchAppLauncher(module)
		.clickOnModule()
		.clickOnMore()
		.clickOnCase()
		.clickOnCaseDropDown()
		.clickNewCase()
		.clickOnContact()
		.selectContact()
		.clickCaseOrigin()
		.selectCaseOrigin(option)
		.clickStatusDropDown()
		.selectStatusDropDown(status)
		.typeSubject(subject)
		.typeDescription(description)
		.clickSave()
		.validateToastMessage(output);
	}
}