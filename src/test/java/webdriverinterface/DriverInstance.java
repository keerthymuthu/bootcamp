package webdriverinterface;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverInstance {
	
	private static final ThreadLocal<RemoteWebDriver> remoteWebDriver=new ThreadLocal<RemoteWebDriver>();
	
	public void setDriver() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		remoteWebDriver.set(new ChromeDriver(options));
	}
	
	public RemoteWebDriver getDriver() {
		return remoteWebDriver.get();
	}

}
