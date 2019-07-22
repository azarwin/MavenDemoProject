package com.qa.easy.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.easy.pages.Log4jpage;
import com.qa.easy.testbase.TestBase;

public class Log4jtest extends TestBase {
	
	Log4jpage log4jpage;
	static Logger log;
	
	public Log4jtest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		LaunchURL(Link);
		log4jpage = new Log4jpage();
	}
	
	@Test(priority=1)
	public static void downloadPDF(){
		log.getLogger(Log4jtest.class.getName());
		Log4jpage.ClickonSampleProgramLink();
		log.info("Sample Program Link Clicked");
		Log4jpage.ClickondownloadFile();
		log.info("PDF button clicked");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
