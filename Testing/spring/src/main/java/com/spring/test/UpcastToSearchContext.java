package com.spring.test;

import java.io.File;
import java.io.IOException;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class UpcastToSearchContext {
	
	public static void main(String[] args) throws IOException {
 
		SearchContext searchContext;
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","");
		searchContext = new ChromeDriver();
		
		// You need to Downcast to use basic methods like get as well
		ChromeDriver driver = (ChromeDriver) searchContext;
		driver.get("http://makeseleniumeasy.com/");
 
		// Taking screenshot
		// To take screenshot we need to downcast to TakesScreenshot interface
		// down casting WebDriver to TakesScreenshot to use getScreenshotAs method.
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotSRC = ts.getScreenshotAs(OutputType.FILE);
		// Defining path and extension of image
		String path = System.getProperty("user.dir") + "/ScreenCapturesPNG/" + System.currentTimeMillis() + ".png";
		// copying file from temp folder to desired location
		File screenshotDest = new File(path);
		FileUtils.copyFile(screenshotSRC, screenshotDest);
 
		// Running javascript command
		// Need to downcast to JavascriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
 
		// Closing browser
		driver.quit();
 
	}
 
 
}

