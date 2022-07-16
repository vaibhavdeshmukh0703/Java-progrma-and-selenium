package com.example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selectGoogleResultDynamicaly {
    public static void main(String[] args) {

        try {

            System.setProperty("webdriver.chrome.driver",
                    "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.co.in");

            driver.manage().window().maximize();

            String Title = driver.getTitle();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.findElement(By.name("q")).sendKeys("java");
         
            List<WebElement> serchSugession = driver
                    .findElements(By.xpath("//ul[@role='listbox']//descendant::li//descendant::div[@class='wM6W7d']"));
          
            for (WebElement element : serchSugession) {
                // System.out.println(element.getText());
                if (element.getText().contains("javascript")) {
                    element.click();
                    break;
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

}
