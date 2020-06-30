package com.fk.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fk.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//h2[contains(text(),'Deals of the Day')]")		
	 WebElement dealsText ;
	
	@FindBy (xpath = "//span[contains(text(),'Plus')]")
	WebElement explorePlus;
	
	@FindBy ( xpath = "//span[contains(text(),'Home & Furniture')]")
	WebElement homeFur ;
	 
	@FindBy (xpath = "//a[contains(text(),'Curtains')]")
	WebElement curtains ;
	
	@FindBy (xpath = "//input[@name ='q']")
	WebElement searchBox;
	
	@FindBy (xpath ="//button[@type ='submit']")
	WebElement searchIcon ;
	
	@FindBy(xpath ="//span[contains(text(),'samsung')]/parent::div[contains(string(),'m11' )]")
	WebElement autoSuggestItem ;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	
		
	}	
		public boolean dealsTextDisplayed() {
			return dealsText.isDisplayed() ;
		}
		
		public ExplorePlus clickOnDeals() throws IOException {
			explorePlus.click();
			return new ExplorePlus() ;		
			
		}
		
		public SearchPage performSearch (String text , String subtext) throws InterruptedException, IOException {
			Thread.sleep(2000);
			searchBox.sendKeys(text);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//span[contains(text(),'"+text+
					"')]/parent::div[contains(string(),'"+subtext+"' )]")).click();
			//autoSuggestItem.click();
			searchIcon.click();
			Thread.sleep(3000);
			return new SearchPage() ;
		}
		
		
		public void selectCategory() throws InterruptedException {
			
		Actions action = new Actions (driver);
		Thread.sleep(3000);
		action.moveToElement(homeFur).build().perform();
		Thread.sleep(3000);
		curtains.click();
		
			
		}


}


