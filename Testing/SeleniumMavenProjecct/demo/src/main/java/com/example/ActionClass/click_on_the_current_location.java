package com.example.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class click_on_the_current_location {
   public static  WebDriver driver =null;

    public static void initialSetup() {
        try{
            System.setProperty("webdriver.chrome.driver",
                    "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
          
            driver = new ChromeDriver();
            driver.get("https://www.google.com");
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            String title = driver.getTitle();
            System.out.println(title);

            testCase();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }finally{
            driver.close();
            System.out.println("Driver class Obj in closed");
        }

    }

    public static void testCase() {

        try {
            WebElement gmail = driver.findElement(By.xpath("//a[text()='Gmail']"));

            Actions actions = new Actions(driver);

            // Get Location Of gmail Co-ordinates

            int getX = gmail.getLocation().getX();
            int getY = gmail.getLocation().getY();
            
            System.out.println("X axis Co-ordinates is "+getX);
            System.out.println("Y axis co-ordinates is "+getY);

            // // Click the web element using action class movetoOffset(x-co, y-co);
            // actions.moveByOffset(getX, getY).click().build().perform();

            // click the web element using actions class click(element) method
            actions.click(gmail).perform();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        initialSetup();
    }
}
