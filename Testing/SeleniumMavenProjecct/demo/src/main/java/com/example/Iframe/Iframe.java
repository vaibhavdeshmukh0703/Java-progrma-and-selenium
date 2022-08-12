package com.example.Iframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframe {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        // Handle iframe
        driver.switchTo().frame("packageListFrame");
        WebElement link = driver.findElement(By.xpath("//a[text()='org.openqa.selenium']"));
        link.click();
        driver.switchTo().defaultContent();

        //for get data from parent frame and your are in child frame 
        //So how can you getBack to parent window

        driver.switchTo().parentFrame();
    }
}
