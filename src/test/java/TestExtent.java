import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExtent {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		//Key in credentials
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf$321");
		//click on login
		driver.findElement(By.id("Login")).click();
		TakesScreenshot tksScreenshot=(TakesScreenshot) driver;
		File f=tksScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("./reports/snap.png"));
		ExtentReports extentReports=new ExtentReports();
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File("./reports/index.html"));
		reporter.setAppendExisting(true);
		extentReports.attachReporter(reporter);
		
		ExtentTest test=extentReports.createTest("test1");
		ExtentTest node=test.createNode("Iteration 2");
		MediaEntityModelProvider m1=MediaEntityBuilder.createScreenCaptureFromPath("./snap.png").build();
		node.log(Status.PASS, "Launch URL");
		node.log(Status.PASS, "Login Successful",m1);
		
		extentReports.flush();
		double n=Math.random();
	}
}
