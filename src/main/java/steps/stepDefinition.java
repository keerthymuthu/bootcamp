package steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDefinition {
	
	public RemoteWebDriver driver;
	public static Properties prop=new Properties();
	
	@Given("I login to Salesforce application")
	public void downloadDriver() throws FileNotFoundException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		prop.load(new FileInputStream(new File("src/main/resources/AppConfig.properties")));
		driver.get(prop.getProperty("appUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		driver.findElement(By.id(prop.getProperty("LoginPage.username.id"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id(prop.getProperty("LoginPage.password.id"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id(prop.getProperty("LoginPage.LoginButton.id"))).click();
	}

	
	@Given("I click on toggle button")
	public void clickonToggleButton() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}
	
	@And("I click on View All button")
	public void viewAll() {
		//WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("HomePage.viewall.xpath"))));
		//ele.click();
		driver.findElement(By.xpath(prop.getProperty("HomePage.viewall.xpath"))).click();
	}
	
	@And("I search for (.*)$")
	public void searchbar(String strsearch) {
		driver.findElement(By.xpath(prop.getProperty("HomePage.searchAppLauncher.xpath"))).sendKeys(strsearch);
	}
}