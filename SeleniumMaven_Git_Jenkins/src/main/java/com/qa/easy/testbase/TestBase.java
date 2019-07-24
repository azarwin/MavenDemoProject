package com.qa.easy.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.easy.testutil.TestUtil;
import com.qa.easy.testutil.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	//public static String Link;
	public static String Location;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream inp = new FileInputStream("C:\\Users\\AZARUDEEN\\git\\MavenDemoProject\\SeleniumMaven_Git_Jenkins"
					+ "\\src\\main\\java\\com\\qa\\easy\\config\\config.properties");
			prop.load(inp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","F:\\Installation\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
	}
	
	public static void LaunchURL(String Link) {
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);	
		
		switch(Link) {
		case "TPurl" : driver.get(prop.getProperty("tpurl"));
		break;
		case "url" : driver.get(prop.getProperty("url"));
		break;
		}
	}
	
	public static String Filedownload(String location) {
		String filepath = System.getProperty(location);
		return filepath;
	}
	
}
