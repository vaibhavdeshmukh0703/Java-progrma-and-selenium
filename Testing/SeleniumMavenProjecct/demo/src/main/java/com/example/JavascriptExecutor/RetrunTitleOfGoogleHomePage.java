package com.example.JavascriptExecutor;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * RetrunTitleOfGoogleHomePage
 */
public class RetrunTitleOfGoogleHomePage {
    public static Properties p = null;
    public static WebDriver driver = null;
    static {
        try {

            String filePath = "./confige.properties";
            p = new Properties();
            FileInputStream fis = new FileInputStream(filePath);
            p.load(fis);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

    }

    public static void initialSetUp() {

        try {
            System.setProperty(p.getProperty("chromeDriver"), p.getProperty("chromeDriverLocationUrl"));
            driver = new ChromeDriver();
            driver.get("http://www.google.com");
            String title = driver.getTitle();
            System.out.println("Page Tile is -->" + title);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            testCase();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        } finally {
            driver.close();
        }
    }

    public static void testCase() {
        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script = "return document.title";
            String Title = (String) js.executeScript(script);
            System.out.println("Page Title is -->" + Title);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        initialSetUp();
    }
}
