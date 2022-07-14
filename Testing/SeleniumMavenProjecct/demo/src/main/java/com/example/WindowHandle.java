package com.example;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandle {
    private static WebDriver driver;

    public static void browserInitialSetup() {
        try {
            System.setProperty("webdriver.chrome.driver",
                    "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
            ChromeOptions co = new ChromeOptions();
            co.addArguments("--headless");

            driver = new ChromeDriver(co);
            driver.get("https://demoqa.com/browser-windows");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            BrowserWindowHandle();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            driver.quit();
        }

    }
    
    public static void BrowserWindowHandle(){
        
     driver.findElement(By.id("windowButton")).click();
      String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if(!handle.equals(mainWindowHandle)){
                driver.switchTo().window(handle);
                System.out.println("child window handle"+handle+"parent window handle"+mainWindowHandle);
            }
        
        }
        System.out.println("Parent window"+mainWindowHandle);

        



    }

    public static void main(String[] args) {
        browserInitialSetup();

    }
}
