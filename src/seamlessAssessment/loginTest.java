package seamlessAssessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import graphql.Assert;
import pageObject.LoginPage;

public class loginTest {

	WebDriver driver = new ChromeDriver();
	LoginPage lp = new LoginPage(driver);

	@BeforeTest
	public void launchbrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");

		driver.get("http://the-internet.herokuapp.com/");
		
		driver.findElement(By.xpath("//a[contains(@href,'/login')]")).click();//locate login
	}

	@Test
	public void validLogin() throws InterruptedException {

		
		lp.enterUsername().sendKeys("tomsmith");
		lp.enterpassword().sendKeys("SuperSecretPassword!");
		lp.getLoginButton().click();

		String actualMessage = driver.findElement(By.xpath("//div[@id ='flash']")).getText();
		// String expectedMessage = "You logged into a secure area!";
		// Assert.assertEquals(actualMessage, expectedMessage);
		Assert.assertTrue(actualMessage.contains("You logged into a secure area!"));
		Thread.sleep(9000);
		

	}
	
	@Test
	public void invalidLogin() throws InterruptedException {

		
		lp.enterUsername().sendKeys("thomas");
		lp.enterpassword().sendKeys("SecretPassword!");
		lp.getLoginButton().click();

		String actualMessage = driver.findElement(By.xpath("//div[@id ='flash']")).getText();
		// String expectedMessage = "You logged into a secure area!";
		// Assert.assertEquals(actualMessage, expectedMessage);
		Assert.assertTrue(actualMessage.contains("Your username is invalid!"));
		Thread.sleep(9000);
		

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
