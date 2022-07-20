package com.example.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Click_and_hold
 */
public class Click_and_hold {
    private static WebDriver driver = null;

    public static void initialSetUp() {
        try {
            System.setProperty("webdriver.chrome.driver",
                    "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
            driver.manage().window().maximize();
            String Page_Title = driver.getTitle();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("Url NAme is ->" + Page_Title);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        TestCase();
    }

    public static void TestCase() {
       try {
         WebElement Button_C = driver.findElement(By.xpath("//li[text()='C']"));

         Actions actions = new Actions(driver);
         //ClickAndHold() using MoveToElement() method
         //actions.moveToElement(Button_C).clickAndHold().perform();

         // By using Overloaded ClickAndHold(Element);
         actions.clickAndHold(Button_C).perform();

       } catch (Exception e) {
        //TODO: handle exception
        System.out.println(e.getMessage());
       }

    }

    public static void main(String[] args) {
        initialSetUp();
    }
}