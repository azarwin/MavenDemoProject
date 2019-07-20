package com.qa.easy.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Image;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.qa.easy.testbase.TestBase;

public class Demopage extends TestBase {
	
	@FindBy(xpath = "//a[contains(text(), 'Selenium Easy')]")
	public WebElement SEImg;
	
	@FindBy(className="cbt")
	WebElement CBTImage;
	
	@FindBy(xpath="//span[@class='round-tabs four']//i[@class='glyphicon glyphicon-chevron-right']")
	WebElement advanced;
	
	@FindBy(xpath="//a[contains(text(),'Table Sort & Search')]")
	WebElement tablesearch;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchbox;
	
	@FindBy(xpath="//table[@id='example']//tbody")
	public WebElement searchresults;
	
	@FindBy(xpath="//a[contains(text(),'TestNG Tutorial')]")
	WebElement TestNGLink;
	
	public Demopage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean CBTImage() {
		return CBTImage.isDisplayed();
	}
	
	public boolean sikuliimgcmp() {
		Screen s = new Screen();
		Pattern p = new Pattern("F:\\Azar\\SeleniumMaven_Git_Jenkins\\SeleniumEasyLogo.PNG");
		boolean out = SEImg.equals(p);
		return out;
	}
	
	
	public void tablesearchlink() {
		advanced.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", tablesearch);		
	}
	
	public void searchboxtxt(String city) {
		searchbox.sendKeys(city);
	}
	
	public TestNGPage TestNG() {
		TestNGLink.click();
		return new TestNGPage();
	}
	
}
