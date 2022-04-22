package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPagePFactory {
	
	WebDriver driver;
	
	public RediffLoginPagePFactory (WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath = ".//*[id='login1']")
	WebElement username;
	
	@FindBy (name = "passwd")
	WebElement password;
	
	@FindBy (name = "proceed")
	WebElement signInButton;
	
	
	public WebElement usernameID() {
		
		return username;
	}
	
	public WebElement passwordName() {
		
		return password;
	}
	
	public WebElement signInButton() {
		
		return signInButton;
	}
	
	

}//class
