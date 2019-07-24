package com.qa.easy.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.easy.testbase.TestBase;

public class Log4jpage extends TestBase{
	
	@FindBy(partialLinkText="PDF")
	WebElement download;
	
	@FindBy(xpath="//h1[contains(text(),'log4j - Sample Program')]")
	static WebElement header;
	
	public static String Expectedh1;
	//public static String actualh1;
	
	public Log4jpage() {
		PageFactory.initElements(driver, this);
	}
	
	public String headers() {
		String actualh1 = header.getText();
		return actualh1;
	}
	
	public void ClickondownloadFile() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", download);
	}
}
