package com.qa.easy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.easy.testbase.TestBase;

public class Log4jpage extends TestBase{
	
	@FindBy(linkText = "log4j - Sample Program")
	static WebElement SampleProgram;
	
	@FindBy(linkText = "PDF")
	static	WebElement download;
	
	public Log4jpage() {
		PageFactory.initElements(driver, this);
	}
	
	public static void ClickonSampleProgramLink() {
		SampleProgram.click();
	}
	
	public static void ClickondownloadFile() {
		download.click();
	}
}
