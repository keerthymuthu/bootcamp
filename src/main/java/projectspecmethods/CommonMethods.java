package projectspecmethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import webdriverinterfaceimpl.Basic;
import week1.TestDataProvider;

public class CommonMethods extends Basic{
	public static Properties properties=new Properties();
	@BeforeMethod
	public void initliaze() throws IOException {
		FileInputStream file=new FileInputStream(new File("src/main/resources/AppConfig.properties"));
		properties.load(file);
		String url=properties.getProperty("appUrl");
		init(url);
	}
	
	@DataProvider(name="fetchData")
	public  Object[][] getData() throws IOException{
		return TestDataProvider.getSheet(dataSheetName);		
	}
	
}
