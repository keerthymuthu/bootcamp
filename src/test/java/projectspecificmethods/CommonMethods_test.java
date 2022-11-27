package projectspecificmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import webdriverinterface.Basic_test;
import week1.TestDataProvider;

public class CommonMethods_test extends Basic_test{
	public static Properties properties=new Properties();
	
	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}
	
	@BeforeClass
	public void beforeClass() {
		startTestCase(testCaseName, testDescription);		
	}
	
	@BeforeMethod
	public void initliaze() throws IOException {
		startTestModule(nodes);
		FileInputStream file=new FileInputStream(new File("src/test/resources/AppConfig_test.properties"));
		properties.load(file);
		String url=properties.getProperty("appUrl");
		init(url);
	}
	
	@DataProvider(name="fetchData")
	public  Object[][] getData() throws IOException{
		return TestDataProvider.getSheet(dataSheetName);		
	}
	@AfterSuite
	public void afterSuite() {
		endResult();
	}
}
