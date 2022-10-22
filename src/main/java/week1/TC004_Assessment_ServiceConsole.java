package week1;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageomodel.LoginPage;

public class TC004_Assessment_ServiceConsole extends BaseClass{
	
	@BeforeTest
	public void initValues() {
		dataSheetName="Assessment";
	}
	
	@Test(dataProvider="fetchData")
	public void assessmentServiceConsole(String username, String password, String module,String message,String fileName,String ext) throws InterruptedException, IOException, AWTException {
		new LoginPage(driver).enterUserName(username).enterPassword(password).clickLogin()
		.clickAppLauncher().clickOnViewAll().searchAppLauncher(module).clickOnServiceConsoleModule().clickOnNavigationDropDown().clickOnFiles()
		.clickOnDropDown().clickOnPublicLink().verifyLinkDisabled().closeModalWindow().clickOnDropDown().clickOnDownload().moveFile()
		.clickOnDropDown().clickOnShare().clickOnShareWithInputBox().selectUserDsouza().validateErrorMsg(message).closeModalWindow().clickOnuploadFiles()
		.clickOnUploadedFileDropDown().clickOnViewFileDetails().verifyFileName(fileName).veriyExtension(ext).closeFileWindow().clickOnFileWindowTab()
		.clickOnUploadedFileDropDown().clickOnDeleteFile().confirmDelete().validateToastMessage();
	}
}
