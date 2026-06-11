package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	
	@Test
	
	//create function
	public void testValidLogin() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		
		loginPage.enterUsername("admin@yourstore.com");
		loginPage.enterPassword("admin");
		loginPage.clickLogin();
		
		System.out.println("Tittle of the page is"+ driver.getTitle());
		
		
		
	}
	

}
