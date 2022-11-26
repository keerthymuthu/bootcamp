package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjectmodel.LoginPage_test;
import projectspecificmethods.CommonMethods_test;

public class TC002_EditAccount_test extends CommonMethods_test{
	@BeforeTest
	public void initValues() {
		dataSheetName="EditAccount_TC002";
	}
	
	@Test(dataProvider="fetchData")
	public void editAccount(String username,String password,String module,String name,String phone,String address) throws InterruptedException {
		new LoginPage_test(driver,test).enterUserName(username).enterPassword(password).clickOnLogin()
		.clickOnAppLauncher().clickOnViewAll().searchAppLauncher(module).clickOnModule().clickOnAccount().searchAccount(name)
		.selectFromSearchResult().clickOnEdit().typePhoneNum(phone).clickOnType().selectType().clickOnIndustry().selectIndustryType()
		.typeBillingAddress(address).typeShippingAddress(address).clickOnCustomerPriority().selectCustomerPriority().clickOnSLA().selectSLASilver()
		.clickOnActive().clickOnNoActive().clickOnUpsellOppo().selectNoUpsellOppo().clickSave().validatePhoneNum(phone);
	}
}
