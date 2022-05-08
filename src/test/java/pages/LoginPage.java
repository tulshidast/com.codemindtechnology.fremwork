package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUserNameTextBox() {
		return driver.findElement(By.xpath("//input[@name='userName']"));
	}

	public WebElement getPasswordTextBox() {
		return driver.findElement(By.xpath("//input[@name='password']"));
	}

	public WebElement getSubmitButton() {
		return driver.findElement(By.xpath("//input[@name='submit']"));
	}

	public String getHomePageTitle() {
		WebElement homePageTitle = driver.findElement(By.xpath("//*[text()='Login Successfully']"));
		return homePageTitle.getText();
	}

}
