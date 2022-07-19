package com.example.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Rightclick_Or_ContextClick {
    public static WebDriver driver = null;

    public static void initialSetUp() {
        try {
            System.setProperty("webdriver.chrome.driver",
                    "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://selenium08.blogspot.com/2019/12/right-click.html");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            testCase();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }finally{
            driver.close();
        }

    }
    public static void testCase(){
        try {
            WebElement rightClickMenu = driver.findElement(By.xpath("//div[@id = 'div-context']"));

            Actions actions = new Actions(driver);
            actions.contextClick(rightClickMenu).perform();

            WebElement python = driver.findElement(By.xpath("//ul//li//a[text()='Python']"));
            actions.click(python).perform();

            Alert alert = driver.switchTo().alert();

            String text = alert.getText();
            System.out.println("Text from alert ->"+text);

            alert.accept();


        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        initialSetUp();
    }
}
