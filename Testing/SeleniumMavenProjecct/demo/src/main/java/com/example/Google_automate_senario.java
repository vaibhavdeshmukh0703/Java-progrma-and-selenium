package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_automate_senario {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/vaibhav/crome_driver/chromedriver_linux64/chromedriver");
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("www.google.com");
            driver.manage().window().maximize();

            driver.findElement(By.xpath("//input[contains(@name,'q')])")).sendKeys("Selenium Automation");
            driver.findElement(By.xpath("//input[contains(@name,'btnK')]")).click();
            System.out.println("Web automation successfuly");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            driver.close();
        }
    }
}
