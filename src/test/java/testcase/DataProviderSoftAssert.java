package testcase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
import utility.PropertiesFile;

public class DataProviderSoftAssert {

	WebDriver driver;
	LoginPage loginPage;

	@BeforeSuite
	public void initializeBrowser() {

	}

	@BeforeMethod
	public void launchApplication() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		driver.get(PropertiesFile.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test
	public void verifyValidLogin() {
		SoftAssert softAssert = new SoftAssert();
		loginPage.getUserNameTextBox().sendKeys(PropertiesFile.getProperty("userName"));
		loginPage.getPasswordTextBox().sendKeys(PropertiesFile.getProperty("password"));
		softAssert.assertTrue(loginPage.getSubmitButton().isSelected());
		loginPage.getSubmitButton().click();

		// Assert.assertEquals(loginPage.getHomePageTitle(), "Login Successfully");

		softAssert.assertEquals(loginPage.getHomePageTitle(), "Login Successfully");
		// Assert.assertTrue(loginPage.getHomePageTitle().equals("Login Successfully"));
		softAssert.assertAll();

	}

	@DataProvider(name = "user-password")
	public Object[][] dataProvider() {

		Object array[][] = { { "test1", "test1" }, { "test2", "test2" }, { "test3", "test3" } };
		return array;

	}

	@Test(enabled = false, dataProvider = "user-password")
	public void verifyLoginByUsingMultipleUsers(String userName, String password) {
		loginPage.getUserNameTextBox().sendKeys(userName);
		loginPage.getPasswordTextBox().sendKeys(password);
		loginPage.getSubmitButton().click();
		
		Assert.assertEquals(loginPage.getHomePageTitle(), "Login Successfully");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
