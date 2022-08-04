package com.example.JavascriptExecutor;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchTextAndClickSubmitButtonOfGoogleHomePage {

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
            //System.setProperty(p.getProperty("chromeDriver"), p.getProperty("chromeDriverLocationUrl"));
            WebDriverManager.chromedriver().setup();
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
        } 
        finally {
            driver.close();
        }
    }

    public static void testCase() {
        try {
            WebElement searchBox = driver.findElement(By.name("q"));
            WebElement submitButton =  driver.findElement(By.name("btnK"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script = "arguments[0].value='Testing',arguments[1].click()";
            js.executeScript(script,searchBox,submitButton);
            

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        initialSetUp();
    }
}
