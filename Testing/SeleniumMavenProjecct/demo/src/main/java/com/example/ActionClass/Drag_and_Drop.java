package com.example.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Drag_and_Drop {
    public static WebDriver driver = null;

    public static void initialSetUp() {
        try {
            System.setProperty("webdriver.chrome.driver",
                    "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String PageTitle = driver.getTitle();
            System.out.println(PageTitle);
            testCase();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void testCase() {
        try {
          
            WebElement sourceElement = driver.findElement(By.xpath("//span[text()='History']"));
            Actions actions = new Actions(driver);
            actions.click(sourceElement).perform();

            // WebElement targetElement = driver.findElement(By.xpath("//li[text()='Ajax in Practice']"));

            // WebDriverWait wait = new WebDriverWait(driver,10);
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Robert Crais]")));
            // Actions actions = new Actions(driver);
            // actions.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        initialSetUp();
    }
}
