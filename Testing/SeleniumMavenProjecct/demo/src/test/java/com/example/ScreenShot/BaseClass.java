package com.example.ScreenShot;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public static WebDriver driver = null;
    public static String screenshotfoldername;

    @BeforeTest
    @Parameters("browserName")
    public void setup(@Optional("chrome") String browserName) {
        try {

            switch (browserName.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    break;

                default:
                throw new Exception("Invalid Browser Name");
                    
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @AfterTest
    public void teadDown() {
        try {
            Thread.sleep(1000);
            driver.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void takeScreenShot(String fileName) {
        try {
            if (screenshotfoldername == null) {
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter df = DateTimeFormatter.ofPattern("ddmmyyyyhhss");
                screenshotfoldername = dateTime.format(df);
            }

            String path = "./Images/" + screenshotfoldername + "/" + fileName + ".jpg";
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File targeFile = new File(path);
            FileUtils.copyFile(sourceFile, targeFile);
            System.out.println("ScreenShot Complited");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
