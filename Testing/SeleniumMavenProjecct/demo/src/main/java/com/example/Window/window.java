package com.example.Window;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class window {
    public static void main(String[] args) {
        try {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://demoqa.com/browser-windows");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            WebElement DemoSiteElement = driver.findElement(By.id("tabButton"));
            DemoSiteElement.click();

            Set<String> windowId = driver.getWindowHandles();
            for (String ids : windowId) {
                System.out.println("Windows Id is --->" + ids);
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
