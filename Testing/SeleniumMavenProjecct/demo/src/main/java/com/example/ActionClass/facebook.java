package com.example.ActionClass;
 import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions; 
public class facebook {
    private static WebDriver driver = null;
    private static Properties props = null;
    static{
      props = new Properties();
      try {
       
        String filePath = "./confige.properties";
        FileInputStream fis = new FileInputStream(filePath);
        props.load(fis);
        
      } catch (Exception e) {
        //TODO: handle exception
        System.out.println(e.getMessage());
      }
    }
    public static void initialSetUp() {
        String filePath = "";
        try {
           
            System.setProperty(props.getProperty("chromeDriver"),
                   props.getProperty("chromeDriverLocationUrl"));
            driver = new ChromeDriver();
            driver.get("https://facebook.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String PageTitle = driver.getTitle();   
            System.out.println(PageTitle);

           TestCase();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            try {
                driver.close();
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }
    }

    public static void TestCase() throws InterruptedException {
      

        WebElement facebook_emaiWebElement = driver.findElement(By.id("email"));
        WebElement facebook_passwordWebElement = driver.findElement(By.id("pass"));
        WebElement facebook_submitButton = driver.findElement(By.xpath("//button[@type = 'submit']"));

        Actions actions = new Actions(driver);

        

        Action facebook_emailWebElementAction = actions.moveToElement(facebook_emaiWebElement)
                .click()
                .sendKeys(props.getProperty("emailId"))
                .build();
        facebook_emailWebElementAction.perform();

        Action facebook_passwordWebElementAction = actions.moveToElement(facebook_passwordWebElement)
                .click()
                .sendKeys(props.getProperty("password"))
                .build();
        facebook_passwordWebElementAction.perform();

        Action facebook_submitButtonAction = actions.moveToElement(facebook_submitButton)
                .click()
                .build();
        facebook_submitButtonAction.perform();
    

    }

    public static void main(String[] args) {
        initialSetUp();
    }
}
