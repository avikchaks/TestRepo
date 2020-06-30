package com.fk.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fk.base.TestBase;
import com.fk.pages.ExplorePlus;
import com.fk.pages.HomePage;
import com.fk.pages.LoginPage;
import com.fk.pages.SearchPage;
import com.fk.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage ;
	HomePage homePage ;
	ExplorePlus explorePlus;
	SearchPage searchPage ;
	String sheetName = "searchText" ;
	
	public HomePageTest() throws IOException {
		super();
	}	
		@BeforeMethod
		public void setup() throws IOException {
			initialization ();	
			loginPage = new LoginPage() ;
			homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
			
		}
		
		
		  @Test 
		  public void verifydeals() throws InterruptedException 
		  { 
			  Boolean flag =  homePage.dealsTextDisplayed(); 
			  Assert.assertTrue(flag, "deals text not displayed");
		  
		  }
		  
		  @Test (dependsOnMethods = "verifydeals")
		  public void verifyExplorePlus()throws Exception 
		  { 
			  explorePlus = homePage.clickOnDeals() ;
		  }
		  
		  @DataProvider
		  public Object [][] getFkData() {
			  Object data[][] = TestUtil.getTestData(sheetName);
			  return data;
		  }
		 
		  
		  @Test (dataProvider="getFkData")
		  public void performSearch(String text, String subText) throws InterruptedException, IOException {
			searchPage = homePage.performSearch(text , subText) ;
			Thread.sleep(1000);
			
			Boolean flag =	searchPage.verifyShowingText();
			Assert.assertTrue(flag, "Search showing text not displayed");
		  }
		  
	

	 @AfterMethod
	 public void teardown() {
		 driver.quit();
	 }

	
}
