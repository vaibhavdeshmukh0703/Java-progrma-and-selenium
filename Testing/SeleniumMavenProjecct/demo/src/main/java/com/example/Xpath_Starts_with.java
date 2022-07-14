package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Starts_with {
public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "/home/vaibhav/crome_driver/chromedriver_linux64/chromedriver");
    WebDriver driver = null;
    try {
        driver = new ChromeDriver();
        driver.get("https://neilpatel.com/ubersuggest");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[starts-with(@name,'keyword')]")).sendKeys("keyword");;
        driver.findElement(By.xpath("//button[starts-with(@type,'submit')]")).click();

    } catch (Exception e) {
        //TODO: handle exception
        System.out.println(e.getMessage());
    }
    finally{
        driver.close();
    }
}    
}
