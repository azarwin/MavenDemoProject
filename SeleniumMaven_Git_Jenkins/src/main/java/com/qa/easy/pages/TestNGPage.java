package com.qa.easy.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.easy.testbase.TestBase;

public class TestNGPage extends TestBase{

	@FindBy(xpath="//a[contains(@class,'active')]")
	WebElement TestNGMenuLink;
	
	@FindBy(xpath="//h1[contains(text(),'TestNG Tutorials')]")
	WebElement header;
	
	@FindBy(linkText="Demo Website!")
	WebElement Demohome;
	
	
	public TestNGPage() {
		PageFactory.initElements(driver, this);
		}
	
	public boolean TestNGLinkActive() {
		String textcolor = TestNGMenuLink.getCssValue("color");
		String Expectedcolor = "rgba(255, 255, 255, 1)";
		if(textcolor.contentEquals(Expectedcolor)) {
			return true;	
			}
		return false;
		}
	
	public String header() {
		String act = header.getText();
		return act;
		}
	
	public Demopage Demohome() {
		Demohome.click();
		return new Demopage();
	}

}
