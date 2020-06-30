package com.fk.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.fk.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop ;
	static EventFiringWebDriver e_driver ;
	static WebEventListener eventListner ;
 public TestBase () throws IOException {
	 prop = new Properties();
	 FileInputStream file = new FileInputStream("C:\\Users\\avikc\\eclipse-workspace\\Flipkart\\src\\main\\java\\com\\fk\\config\\config.properties");
	 prop.load(file);
	 
 }
	 
	 public static void initialization() throws IOException {
		 
		 String browserName = prop.getProperty("browser");
		 if (browserName.equals("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\avikc\\eclipse-workspace\\Flipkart\\src\\main\\java\\com\\fk\\drivers\\chromedriver.exe") ;
			 ChromeOptions options = new ChromeOptions();
			// options.addArguments("headless");
		        options.addArguments("window-size=1200x600");
			 driver = new ChromeDriver (options); 
		 }
		 else if (browserName.equals("firefox")) {
			 System.setProperty("webdriver.firefox.driver", "C:\\Users\\avikc\\eclipse-workspace\\Flipkart\\src\\main\\java\\com\\fk\\drivers\\geckodriver.exe");
			 driver = new FirefoxDriver ();
		 }
		 //register object inherited from WebDriverEventListener and register it object of EventFiringWebDriver
	 e_driver = new EventFiringWebDriver(driver) ;
	 eventListner = new WebEventListener ();
	 e_driver.register(eventListner) ;
	 driver = e_driver ;

	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS) ;
	 
	 driver.get(prop.getProperty("url"));
	 
	 }
 }
	

