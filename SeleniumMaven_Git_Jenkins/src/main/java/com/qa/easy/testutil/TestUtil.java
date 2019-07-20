package com.qa.easy.testutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.qa.easy.testbase.TestBase;

public class TestUtil extends TestBase {
	
	public static String src = "F:\\Azar\\SeleniumMaven_Git_Jenkins"
			+ "\\src\\main\\java\\com\\qa\\easy\\testdata\\TestData.xlsx";
	public static XSSFWorkbook WB;
	public static XSSFSheet sheet;
	public static long PAGE_LOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 40;
	
	
	public static Object[][] getTestData(String sheetName) throws IOException {
		FileInputStream TD = new FileInputStream(src);
		XSSFWorkbook WB = new XSSFWorkbook(TD);
		XSSFSheet sheet = WB.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastColumn = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow][lastColumn];
			for (int i = 0; i < lastRow; i++) {
				for (int k = 0; k < lastColumn; k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					}
			}
		return data;
	}

	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("F:\\Azar\\SeleniumMaven_Git_Jenkins");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".jpg"));
	}
		
}