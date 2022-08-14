package com.example.Links;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Links
 */
public class Links {

    public static void main(String[] args) {
        initialSetUp();
    }

    private static void initialSetUp() {
        WebDriver driver = null;
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            openLinksIntoNewTabs(driver);
            openLinksIntoNewWindow(driver);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                // driver.quit();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

    private static void openLinksIntoNewWindow(WebDriver driver) {
        try {
           // driver.switchTo().newWindow(WindowType.WINDOW); from selenium 4 Onword this method works
           //driver.get('facebook.com')
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    private static void openLinksIntoNewTabs(WebDriver driver) {
        try {
            WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
            gmailLink.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
            Thread.sleep(3000);

            Set<String> windowId = driver.getWindowHandles();
            Iterator it = windowId.iterator();

            String firstWindow = (String) it.next();
            String secondWindow = (String) it.next();
            System.out.println(firstWindow + "  " + secondWindow);

            driver.switchTo().window(secondWindow);
            System.out.println(driver.getTitle());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
