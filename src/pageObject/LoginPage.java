package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By getUsername = By.id("username");
	By getPassword = By.id("password");
	By loginButton = By.xpath("//button[@type ='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver =driver;
	
	}
	
	
	public WebElement enterUsername() {
		return driver.findElement(getUsername);
	}
	
	
	public WebElement enterpassword() {
		return driver.findElement(getPassword);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}

}
