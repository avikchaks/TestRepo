package com.fk.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fk.base.TestBase;
import com.fk.pages.ExplorePlus;
import com.fk.pages.HomePage;
import com.fk.pages.LoginPage;
import com.fk.pages.SearchPage;

public class SearchPageTest extends TestBase {

	LoginPage loginPage ;
	HomePage homePage ;
	//ExplorePlus explorePlus;
	SearchPage searchPage ;

	SearchPageTest() throws IOException {
		super();
	}

	@BeforeMethod 
	public void setup() throws IOException, InterruptedException {
		initialization () ;
		loginPage = new LoginPage() ;
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		searchPage = homePage.performSearch(null, null);
	}
	
	@Test
	public void verifyShowingText()  {
	Boolean flag =	searchPage.verifyShowingText();
	Assert.assertTrue(flag, "Search showing text not displayed");
		
	}


}
