package com.fk.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fk.base.TestBase;

public class ExplorePlus extends TestBase {

	@FindBy (xpath ="//a[@href='https://www.flipkart.com/plus/coins-activity']")
	WebElement myCoinBalance ;
	
	
	public ExplorePlus () throws  IOException  {
		PageFactory.initElements(driver, this);
	}

	public String MyCoinBalance() {
		myCoinBalance.click();
		return driver.getTitle() ;
				
	}
}

