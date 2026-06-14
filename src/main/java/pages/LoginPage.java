package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import utils.Log;

public class LoginPage {
  
	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement usernameTextbox;
	
	@FindBy(id="Password")
	WebElement passwordTestBox;
	
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement logingButton;
	
	
	
	
	
	//private By usernameTextBox = By.id("Email");
	//private By passwordTextBox = By.id("Password");
	//private By loginButton = By.xpath("//button[@type=\"submit\"]");
	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterUsername(String username) {
		
		 usernameTextbox.clear();
		 usernameTextbox.sendKeys(username);
		//driver.findElement(usernameTextBox).clear();
		
		//driver.findElement(usernameTextBox).sendKeys(username);
		
		
	}
	
	public void enterPassword(String password) {
		
		passwordTestBox.clear();
		passwordTestBox.sendKeys(password);
		
		//driver.findElement(passwordTextBox).clear();
		//driver.findElement(passwordTextBox).sendKeys(password);
		
	}
	
	public void clickLogin()
	
	{
		Log.info("Clicking login button");
		
		logingButton.click();
		//driver.findElement(loginButton).click();
		
	}
	
	
	}
	
	

