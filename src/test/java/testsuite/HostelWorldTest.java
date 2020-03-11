package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import core.DriverFactory;

public class HostelWorldTest extends DriverFactory {  // TestNG Class
	
	private WebDriver driver = null;
	
	@BeforeClass
	public void InitTest() {
		String browserName = "chrome";
		driver = getDriver(browserName);
		driver.get("https://www.hostelworld.com");
	}
	
	@Test   // Considered as Test Methods in TestNG World
	public void Verify_Empty_City_Display_Error_Approach_1() {
		driver.findElement(By.xpath(".//button[text()=\"Let's go!\"]")).click();
		
		WebElement invalidText = driver.findElement(By.xpath(".//div[@class='invalid-feedback']"));
		String actualInvalidTextString = invalidText.getText();
		String expectedInvalidText = "To view prices and availability, please enter a location.";
		
		if(actualInvalidTextString.equals(expectedInvalidText)) {
			System.out.println("Verify_Empty_City_Display_Error - PASSED");
		}else {
			System.out.println("Verify_Empty_City_Display_Error - FAILED");
		}
	}
	
	@AfterClass
	public void cleanUp() {
		driver.quit();
	}

}
