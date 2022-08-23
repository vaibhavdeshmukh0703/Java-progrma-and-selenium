package com.example.ScreenShot;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase extends BaseClass{
    @Test(dataProvider = "facebookLogin", dataProviderClass = DataProviderClass.class)
       
    public void facebookTest(String url,String username,String password){
        
        try {
            driver.get(url);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement usernameElement = driver.findElement(By.id("email"));
            usernameElement.sendKeys(username);

            WebElement  passwordElement= driver.findElement(By.id("pass"));
            passwordElement.sendKeys(password);
            passwordElement.sendKeys(Keys.ENTER);

            Assert.assertTrue(false);
           

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    //-------------------------------------Test for Google Search-------------------------------
     @Test(dataProvider = "googleSearchData", dataProviderClass=DataProviderClass.class)

     public void googleSearchTest(String url) {
          // Create an object of FirefoxDriver class to open Firefox browser.
          
          driver.get(url);
          
          WebElement expecetedTitle = driver.findElement(By.name("q"));
          expecetedTitle.sendKeys("vaibhav",Keys.ENTER);
          String expectedTitle = "vaibhav - Google Search";

          String getTitle = driver.getTitle();
          System.out.println("Title of home page: " + getTitle);

          assertEquals( getTitle, expectedTitle);
        

     }


}
