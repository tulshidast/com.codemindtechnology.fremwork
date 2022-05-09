package testcase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import utility.PropertiesFile;

public class ParallelExecution {

	WebDriver driver;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/Desktop/Jars/chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		driver.get(PropertiesFile.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test(priority = -1, enabled = true, groups = { "group1" })
	public void first() {
		System.out.println("first executed");

	}

	@Test(priority = 1, groups = { "group1" })
	public void second() {
		System.out.println("second executed");
	}

	@Test(priority = 1, groups = { "group1" })
	public void third() {
		System.out.println("third executed");
	}

	@Test(priority = 1, groups = { "group2" })
	public void fourth() {
		System.out.println("fourth executed");
	}

	@Test(priority = 1, groups = { "group2" })
	public void fifth() {
		System.out.println("fifth executed");
	}

	@Test(priority = -2, groups = { "group2" })
	public void six() {
		System.out.println("six executed");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
