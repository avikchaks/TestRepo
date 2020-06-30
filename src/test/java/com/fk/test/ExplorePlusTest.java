package com.fk.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fk.base.TestBase;
import com.fk.pages.ExplorePlus;
import com.fk.pages.HomePage;
import com.fk.pages.LoginPage;

public class ExplorePlusTest extends TestBase {
	
	LoginPage loginPage ;
	HomePage homePage ;
	ExplorePlus explorePlus;
	
	ExplorePlusTest() throws IOException {
		super() ;
	}

	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization() ;
		loginPage = new LoginPage() ;
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(1000);
		explorePlus = homePage.clickOnDeals();
				
	}


	@Test
	public void landOnCoinActivity() {
		String title = explorePlus.MyCoinBalance();
		Assert.assertEquals(title , "Coins Balance – Check confirmed Flipkart coins for your Account","Coin Balance title is incorrect");
		
		
	}
	

	@AfterMethod
	public void teardown () {
		
		driver.quit();
	}
	
}
