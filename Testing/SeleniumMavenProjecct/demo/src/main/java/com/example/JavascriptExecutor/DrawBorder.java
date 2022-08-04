package com.example.JavascriptExecutor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DrawBorder {
    public static WebDriver driver = null;

    public static void initialSetUp() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
           // driver.get("http://www.google.com");
           driver.get("https://www.scientecheasy.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // // Draw border to element and take sccreen shote of that page
            // WebElement imageLink = driver.findElement(By.xpath("//a[text()='Images']"));
            // String targetFileName = "imageScreenShot";
            // UtilsMethod.drawBorder(driver, imageLink);
            // UtilsMethod.takeScreenShot(driver, null, targetFileName);

            // // Takes Screenshots
            // imageLink = driver.findElement(By.xpath("//a[text()='Images']"));
            // targetFileName = "imageScreenShot";
            // UtilsMethod.takeScreenShot(driver, null, targetFileName);

            // //Get Page Title
            // UtilsMethod.getPageTilte(driver);

            // // Generate Alert From JS
            // String message ="Hello QA";
            // UtilsMethod.generateAlert(driver, message);

            // Refresh crrent web page
            //UtilsMethod.refereshPage(driver);

            // Scroll Down Page
            //UtilsMethod.scrollDown(driver);
            Thread.sleep(4000);
            // Scroll Up
            //UtilsMethod.scrollUp(driver);

            //  Page Zoom 
         //   UtilsMethod.ZoomPage(driver, 150);

            // flash page
            WebElement element = driver.findElement(By.xpath("//a[text()='Home']"));
            UtilsMethod.changeColor("#000000", driver,element);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void applyStyleSheet() {
        try {

            String Script = "arguments[0].style.border='4px solid blue',arguments[0].style.padding='5px'";
            WebElement gmailTab = driver.findElement(By.xpath("//a[text()='Images']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(Script, gmailTab);

            TakesScreenshot ts = (TakesScreenshot) driver;
            File scr = ts.getScreenshotAs(OutputType.FILE);
            String targetLocation = "./Testing/SeleniumMavenProjecct/demo/src/main/java/com/example/Images/gmailScreenshot1.jpg";
            File target = new File(targetLocation);
            FileUtils.copyFile(scr, target);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        initialSetUp();
        // applyStyleSheet();
    }
}
