package com.example.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class facebook {
    private static WebDriver driver = null;
    public static void initialSetUp(){
        try {
            System.setProperty("webdriver.chrome.driver", "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://facebook.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String PageTitle = driver.getTitle();
            System.out.println(PageTitle);
    
            TestCase();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
        //finally{
        //     try {
        //         //driver.close();
        //     } catch (Exception e) {
        //         //TODO: handle exception
        //         System.out.println(e.getMessage());
        //     }
        // }
        }
    
    
    
    public static void TestCase() {
        WebElement facebook_emaiWebElement = driver.findElement(By.id("email"));
        Actions actions = new Actions(driver);

        Action emainAction = actions.moveToElement(facebook_emaiWebElement)
                            .click()
                            .keyDown(facebook_emaiWebElement, Keys.SHIFT)
                            .sendKeys("vaibhav")
                            .keyUp(facebook_emaiWebElement,Keys.SHIFT)
                            .doubleClick(facebook_emaiWebElement)
                            .contextClick()
                            .build();

        emainAction.perform();

    }
   public static void main(String[] args) {
    initialSetUp();
   } 
}
