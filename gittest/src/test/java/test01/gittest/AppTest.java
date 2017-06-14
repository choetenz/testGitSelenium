package test01.gittest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class AppTest {
	
	@Test
	public void gitTestTutorials() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String testTitle = "Facebook - Log In or Sign Up";
		String actualTitle = "";
		
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		actualTitle = driver.getTitle();
		
		if(actualTitle.contentEquals(testTitle)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		
		driver.close();
	}
	
}
