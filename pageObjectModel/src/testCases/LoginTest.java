package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objectRepository.RediffLoginPage;

public class LoginTest {

	@Test
	public void LogintoWebsite() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home") + "//eclipse-workspace//chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		RediffLoginPage loginPage = new RediffLoginPage(driver);
		
		loginPage.usernameID().sendKeys("testUsernamePageObject");
		loginPage.passwordName().sendKeys("testPasswordPageobject");
		loginPage.signInButton().click();
		
		
	}//login
	
	@Test
	public void test() {
		
	}

}//class
