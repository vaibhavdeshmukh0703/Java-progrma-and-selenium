package com.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args)

    {
        try {
            // WebDriverManager.chromedriver().create();
            // WebDriver driver = WebDriverManager.chromedriver().create();

            System.setProperty("webdriver.chrome.driver", "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");

             ChromeOptions co = new ChromeOptions();
			co.addArguments("--headless");

            WebDriver driver = new ChromeDriver(co); 
            String url ="https://www.google.com";
            driver.get(url);
            /////driver.navigate().to("https://www.facebook.com/login");
            //driver.navigate().forward();
            ///driver.navigate().back();
            //driver.navigate().refresh();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
           // driver.manage().window().fullscreen();
           String returnURL = driver.getCurrentUrl();
            driver.manage().window().maximize();
            if(url.equals(returnURL)){
                System.out.println("page loaded");
            }
            else{
                System.out.println("page is not loaded");
            }
            
            System.out.println(
                    "Title Of Page is ->" + driver.getTitle() + "  Get open Page url is -> " + driver.getCurrentUrl());
            
        } catch (Exception e) {
            System.out.println("Exception Happen" + e.getMessage());
        }

    }
}
