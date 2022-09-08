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

            String title = driver.getTitle();
            //String windowId = driver.getWindowHandle();

            //System.out.println(title + " " + windowId);

            WebElement DemoSiteElement = driver.findElement(By.id("tabButton"));
            DemoSiteElement.click();

            Set<String> windowIds = driver.getWindowHandles();
            for (String ids : windowIds) {
                String title1 = driver.switchTo().window(ids).getTitle();
                System.out.println(title1 + " " + ids);
                if (title.equals(title1)) {
                    System.out.println("from Inside-->" + title + "  " + ids);
                    driver.switchTo().window(ids);
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
          e.printStackTrace();
        }
    }
}
