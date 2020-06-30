package com.fk.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fk.base.TestBase;

public class SearchPage extends TestBase {

	@FindBy (xpath ="//span[contains(text(),'Showing')]")
	WebElement showingText;
	
	public SearchPage() throws IOException {
		PageFactory.initElements(driver,this);
	}
	
 public boolean verifyShowingText() {
	 return showingText.isDisplayed() ;
 }
	
}
