package com.example.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Double_clicl_action {
    public static WebDriver driver = null;

    public static void initialSetUp() {
        try {
            System.setProperty("webdriver.chrome.driver",
                    "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://selenium08.blogspot.com/2019/11/double-click.html");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            String title = driver.getTitle();
            System.out.println("web page title is " + title);

            testCase();
        } catch (Exception e) {
            // TODO: handle exception

        } finally {
            driver.close();
        }

    }

    public static void testCase() {
        try {
            WebElement doubleClickAction = driver
                    .findElement(By.xpath("//button[text()='Double-Click me to see Alert message']"));
            Actions actions = new Actions(driver);
            // // action class doubleClick(element) method
            // actions.doubleClick(doubleClickAction).perform();

            // action class moveToElement(element).doubleClick()
            actions.moveToElement(doubleClickAction).doubleClick().perform();

            Alert alert = driver.switchTo().alert();
            String AlertMassage = alert.getText();
            System.out.println("Alert Message is ->" + AlertMassage);
            alert.accept();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        initialSetUp();
    }

}
