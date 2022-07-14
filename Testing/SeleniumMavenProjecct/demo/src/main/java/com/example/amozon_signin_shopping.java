package com.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amozon_signin_shopping {
    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver",
                    "/home/vaibhav/crome_driver/chromedriver_linux64/chromedriver");
            WebDriver driver = new ChromeDriver();

            // Open amazon.in , maximize window and wait window for 10 sec to load page
            driver.get("https://www.amazon.in");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Explicite wait 1o sec for specifice element to load 
            WebDriverWait wait = new WebDriverWait(driver, 10);

            // find element sign in and click to it to open sign in page
            driver.findElement(By.id("nav-link-accountList")).click();

            // wait 10 sec to load email text field.
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));

            // after loading Email textfield select email field to fill email address to it and click submit button.
            driver.findElement(By.name("email")).sendKeys("vaibhavdeshmukh0703@gmail.com");
            driver.findElement(By.id("continue")).click();

             wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
            // after loading Email textfield select email field to fill email address to it and click submit button.
            driver.findElement(By.name("password")).sendKeys("vaibhav@123");
            driver.findElement(By.id("signInSubmit")).click();

            //After sing in.  wait 10 second to load hoem page. then search java book using search tab.
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("selenium automation testing book");
            driver.findElement(By.id("nav-search-submit-button")).click();

            // afer searching  book wait 10 sec to load hole page and then click book to open page         
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Absolute Beginner (Part 1) Java 4 Selenium WebDriver: Come Learn How To Program For Automation Testing']")));
            driver.findElement(By.xpath("//span[text()='Absolute Beginner (Part 1) Java 4 Selenium WebDriver: Come Learn How To Program For Automation Testing']")).click();
            




        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
