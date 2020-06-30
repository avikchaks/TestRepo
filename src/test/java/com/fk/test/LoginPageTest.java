package com.fk.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fk.base.TestBase;
import com.fk.pages.HomePage;
import com.fk.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage ;
	HomePage homePage ;
	public LoginPageTest() throws IOException {
		super() ;
		
	}
	
	@BeforeMethod 
	public void setup() throws IOException  {
		initialization ();
		loginPage = new LoginPage();
			
	}
	
	@Test (priority = 1)
	public void LoginPageDisplayed() {
		
	Boolean isdisplayed =	loginPage.validateLoginButton();
		Assert.assertTrue (isdisplayed);
	}
	
	@Test (priority =2)
	public void LoginPageTitle( ) {
		
	String title =	loginPage.validateLoginPageTitle() ;
	Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	
	}
	
	@Test (priority =3)
	public void LoginTest() throws IOException, InterruptedException {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")) ;
		Thread.sleep(2000);
	}
	
	
	
	@AfterMethod
	public void teardown () {
		
		driver.quit();
	}
	
	
}
