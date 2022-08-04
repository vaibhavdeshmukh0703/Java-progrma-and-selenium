package com.example.ScreenShots;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeSreenShots {
   private static WebDriver driver = null;
    
    public static void initialSetUp(){
       try {
         WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        testCase();
       } catch (Exception e) {
        //TODO: handle exception
        System.out.println(e.getMessage());
       }
    }
    public static void testCase(){
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        screenshot.getScreenshotAs(null);
    }
   public static void main(String[] args) {
    initialSetUp();
   } 
}
