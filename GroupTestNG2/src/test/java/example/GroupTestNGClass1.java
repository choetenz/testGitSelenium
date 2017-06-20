package example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupTestNGClass1 {
	
	public static WebDriver driver;
	
	String launchPageHeading = "//h2[text()='Guru99 Bank']";
	final String unameElement = "//input[@name='uid']", 
			pwdElement = "//input[@name='password']", 
			signInElement = "//input[@name='btnLogin']";
	final String uname = "mngr81197", pwd = "mAnytav";
	final String managerID = "//td[contains(text(), 'Manger Id')]";
	final String newCustomer = "//a[@href='addcustomerpage.php']", 
			fundTransfer = "//a[@href='FundTransInput.php']";
	
	// this test case will initialize the webdriver
	@Test(groups = { "bonding", "strong_ties" })
	public void tc01LaunchURL() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.demo.guru99.com/v4/");
	}
	
	// this test case will enter user name, password and click siginin button
	@Test(groups = { "bonding"})
	public void tc02VerifyLaunchPage() {
		Assert.assertTrue(driver.findElement(By.xpath(launchPageHeading))
		.isDisplayed(), "Home Page heading is not displayed");
		System.out.println("Home Page heading is displayed");
	}
	
	@Test(groups = { "bonding", "strong_ties" })
	public void tc03EnterCredentials() {
		driver.findElement(By.xpath(unameElement)).sendKeys(uname);
		driver.findElement(By.xpath(pwdElement)).sendKeys(pwd);
		driver.findElement(By.xpath(signInElement)).click();
	}
	
	// this test case will verify managers Id presence on Dashboard
	@Test(groups = { "strong_ties" })
	public void tc04VerifyLoggedInPage() {
		Assert.assertTrue(driver.findElement(By.xpath(managerID)).isDisplayed(),
				"Manager ID label is not displayed");
		System.out.println("Manager Id label is displayed");
	}
	
	// this test case will check presenece of New Customer and FundTransfer Link in left panel
	@Test(groups = { "bonding" })
	public void tc05VerifyIfHyperLink() {
		Assert.assertTrue(driver.findElement(By.xpath(newCustomer)).isEnabled(),
				"New customer hyperlink is not displayed");
		System.out.println("New customer hyperlink is displayed");
		
		Assert.assertTrue(driver.findElement(By.xpath(fundTransfer)).isEnabled(),
				"Fund Transfer hyperlink is not displayed");
		System.out.println("Fund Transfer hyperlink is displayed");
	}
	
	@BeforeTest(alwaysRun = true)
	public void beforeTest() {
		//System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterTest(alwaysRun = true)
	public void afterTest() {
		driver.quit();
	}
}
