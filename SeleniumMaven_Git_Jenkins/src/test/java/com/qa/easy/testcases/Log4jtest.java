package com.qa.easy.testcases;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.easy.pages.Log4jpage;
import com.qa.easy.testbase.TestBase;

public class Log4jtest extends TestBase {
	
	static Log4jpage log4jpge;
	static Logger log = Logger.getLogger(Log4jtest.class.getName());
	String Link = "TPurl";
	
	public Log4jtest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		LaunchURL(Link);
		log4jpge = new Log4jpage();
		BasicConfigurator.configure();
	}
	
	@Test(priority=1)
	public static void logspclick(){
		log4jpge.headers();
		String act = log4jpge.headers();
		System.out.println(act);
		Assert.assertEquals(act, "log4j - Sample Program", "Header Mismatch");
		log.info("Headers verified");
	}
	
	
	@Test(priority=2)
	public static void downloadPDF() throws InterruptedException{
		log4jpge.ClickondownloadFile();
		ArrayList<String> Windows = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(Windows);
		Thread.sleep(3000);
		System.out.println(driver.switchTo().window(Windows.get(1)).getCurrentUrl());
		log.info("PDF button clicked");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
