package com.example.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Slider
 */
public class Slider {

    public static void main(String[] args) {
        initialSetUp();
    }

    private static void initialSetUp() {
        try {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            String title = driver.getTitle();
            System.out.println("web page title is " + title);

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
} 

