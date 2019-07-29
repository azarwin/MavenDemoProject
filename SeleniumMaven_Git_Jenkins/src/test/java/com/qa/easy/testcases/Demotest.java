package com.qa.easy.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.qa.easy.pages.Demopage;
import com.qa.easy.testbase.TestBase;
import com.qa.easy.testutil.TestUtil;

public class Demotest extends TestBase{
	
	Demopage demopage;
	String sheetName = "Sheet1";
	String Link = "url";
	
	public Demotest() throws IOException {
		super();		
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		LaunchURL(Link);
		demopage = new Demopage();	
	}
	
	@Test(priority=1)
	public void cbtLogo(){
		boolean flag = demopage.CBTImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void sikuliimg() throws InterruptedException {
		Boolean flag = demopage.sikuliimgcmp();
		System.out.println(flag);
		Assert.assertTrue(flag);
		demopage.SEImg.click();
	}
	
	@DataProvider
	public Object[][] getcityTestData() throws IOException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=3, dataProvider = "getcityTestData")
	public void searchfilter(String City) throws IOException {
		demopage.tablesearchlink();
		demopage.searchboxtxt(City);
		List<WebElement> rows = demopage.searchresults.findElements(By.tagName("tr"));
		for (WebElement employee : rows)
		{
			List<WebElement> Office = employee.findElements(By.tagName("td"));
			String OfficeLocation = Office.get(2).getText();
			Assert.assertEquals(OfficeLocation, City);
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
