package com.qa.easy.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.easy.pages.Demopage;
import com.qa.easy.pages.TestNGPage;
import com.qa.easy.testbase.TestBase;

public class TestNGtest extends TestBase{
	
	Demopage demopage;
	TestNGPage testNGPage;
	
	public TestNGtest() {
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		demopage = new Demopage();
		testNGPage = new TestNGPage();
		demopage.TestNG();
	}
	
	@Test(priority=1, groups="grp")
	public void TestNGLinkHighlight() {
		Assert.assertTrue(testNGPage.TestNGLinkActive(), "This page is Active and link is highlighted");
	}
	
	@Test(priority=2, groups="grp")
	public void TestNGHeader() {
		Assert.assertEquals(testNGPage.header(), "TestNG Tutorials");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
