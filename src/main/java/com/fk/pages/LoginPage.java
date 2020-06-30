package com.fk.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fk.base.TestBase;

public class LoginPage extends TestBase {
	
	// Page Factory 
	@FindBy (xpath = "//span[contains(text(),'Enter Email/Mobile number')]/../..//input")
	WebElement loginTxt ;
	
	@FindBy (xpath = "//input[@type='password']")
	WebElement passwordTxt ; 
	
	@FindBy (xpath = "//span[contains(text(),'Login')]/parent::button[@type='submit']")
	WebElement LoginBtn ;
	
	//Action 
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
		
	}
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public boolean validateLoginButton() {
		return LoginBtn.isDisplayed() ;
	}
	
	public HomePage login (String username , String password) throws IOException {
		loginTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		LoginBtn.click();
		return new HomePage() ;
		
	}
	
	
	
}
