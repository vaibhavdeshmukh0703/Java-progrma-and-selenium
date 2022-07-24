package com.example.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class facebook {
    private static WebDriver driver = null;

    public static void initialSetUp() {
        try {
            System.setProperty("webdriver.chrome.driver",
                    "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
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

    public static void TestCase() {
        String emailId = "vaibhavdeshmukh0703@gmail.com";
        String password = "";

        WebElement facebook_emaiWebElement = driver.findElement(By.id("email"));
        WebElement facebook_passwordWebElement = driver.findElement(By.id("pass"));
        WebElement facebook_submitButton = driver.findElement(By.xpath("//button[@type = 'submit']"));

        Actions actions = new Actions(driver);

        // Action emainAction = actions.moveToElement(facebook_emaiWebElement)
        // .click()
        // .keyDown(facebook_emaiWebElement, Keys.SHIFT)
        // .sendKeys("vaibhav")
        // .keyUp(facebook_emaiWebElement,Keys.SHIFT)
        // .doubleClick(facebook_emaiWebElement)
        // .contextClick()
        // .build();

        Action facebook_emailWebElementAction = actions.moveToElement(facebook_emaiWebElement)
                .click()
                .sendKeys(emailId)
                .build();
        facebook_emailWebElementAction.perform();

        Action facebook_passwordWebElementAction = actions.moveToElement(facebook_passwordWebElement)
                .click()
                .sendKeys(password)
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
