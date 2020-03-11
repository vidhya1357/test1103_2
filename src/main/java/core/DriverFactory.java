package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private WebDriver driver = null;
	
	public WebDriver getDriver(String browser) {	
		switch(browser.toLowerCase()) {
			case "chrome"  : 
				System.setProperty("webdriver.chrome.driver", "C:\\Dublin\\Download\\chromedriver_win32\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "firefox" :
				System.setProperty("webdriver.firefox.driver", "C:\\Dublin\\Download\\geckodriver-v0.26.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			default : System.out.println("Incorrect browser name provided "+ browser);
				
		}
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);  // One time config done for the whole project
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // One time config
		return driver;	
	}
	
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
