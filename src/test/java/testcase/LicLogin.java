package testcase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LicLogin {

	@Test
	public void licLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Administrator/Desktop/Jars/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://licindia.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		Thread.sleep(2000);

		WebElement elm = driver.findElement(By.xpath("//div[@class='tab-left']//a[contains(@href,'Customer-Portal')]"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", elm);
		executor.executeScript("arguments[0].click();", elm);

	}

}
