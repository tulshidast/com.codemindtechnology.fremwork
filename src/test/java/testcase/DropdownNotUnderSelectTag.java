package testcase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DropdownNotUnderSelectTag {
	WebDriver driver;

	@Test
	public void main() throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.airvistara.com/in/en");
		driver.findElement(By.xpath("//button[@data-toggle='dropdown']")).click();
		Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='flagstrap-drop-down-list']//li//img"));

		for (WebElement elm : list) {
			if (elm.getAttribute("src").contains("nepal"))
				elm.click();
		}

		driver.findElement(By.id("domain-done")).click();
	}

}
