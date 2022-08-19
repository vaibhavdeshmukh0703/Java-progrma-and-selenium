package com.example;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
     // Create WebDriver reference.
     public WebDriver driver;
     @Parameters("browserName")
     @BeforeSuite
     public void initialSetUp(String browserName) {
          try {
               switch (browserName.toLowerCase()) {
                    case "chrome":
                          WebDriverManager.chromedriver().setup();
                         driver = new ChromeDriver();
                         break;
                    
                    case "firefox":
                          WebDriverManager.firefoxdriver().setup();
                         driver = new FirefoxDriver();
                         break;
                    case "edge":
                          WebDriverManager.edgedriver().setup();
                         driver = new EdgeDriver();
                         break;     
                    default:
                    throw new Exception("Invalid Browser Name");
                         
               }
              

          } catch (Exception e) {
               // TODO: handle exception
               System.out.println(e.getMessage());
          }
          driver.manage().window().maximize();
     }
     @Parameters("url")
     public void LounchApp(String url){
          try {
               driver.get(url);
          } catch (Exception e) {
               //TODO: handle exception
               System.out.println(e.getMessage());
          }
     }

     @Test
     public void googlePageTest() {
          // Create an object of FirefoxDriver class to open Firefox browser.
          String URL = "https://www.google.com"; // Creating string literal.
          driver.get(URL);
          
          WebElement expecetedTitle = driver.findElement(By.name("q"));
          expecetedTitle.sendKeys("vaibhav",Keys.ENTER);
          String expectedTitle = "vaibhav - Google Search";

          String getTitle = driver.getTitle();
          System.out.println("Title of home page: " + getTitle);

          assertEquals( getTitle, expectedTitle,"Title Mismatch");
          // Call close() method to close browser.
          driver.close();

     }

     @Test(description = "Test for FaceBook Login")
     public void facebookTest() {
          try {
               String URL = "https://www.facebook.com"; // Creating string literal.
               driver.get(URL);
               System.out.println("Title of Page"+driver.getTitle());
               WebElement email = driver.findElement(By.id("email"));
               email.sendKeys("vaibhav");
               email.sendKeys(Keys.ENTER);
          } catch (Exception e) {
               System.out.println(e.getMessage());
          }
     }
}