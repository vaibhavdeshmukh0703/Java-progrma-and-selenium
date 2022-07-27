package com.example.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_and_Drop {
    public static WebDriver driver = null;

    public static void initialSetUp() {
        try {
            System.setProperty("webdriver.chrome.driver",
                    "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
            driver = new ChromeDriver();
            // driver.get("https://selenium08.blogspot.com/2020/01/drag-me.html");
            driver.get("https://selenium08.blogspot.com/2020/01/drag-drop.html");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String PageTitle = driver.getTitle();
            System.out.println(PageTitle);
          //  testCase();
            testCase1();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void testCase1() {
        try {
            WebElement src = driver.findElement(By.id("draggable"));
            WebElement trgt = driver.findElement(By.id("droppable"));

            // Create an object of Actions class and pass driver object reference to its
            // constructor.
            Actions actions = new Actions(driver);

            // Call dragAndDrop() method of actions class.
            actions.dragAndDrop(src, trgt);
            actions.build().perform();

            System.out.println("Drag and drop action has been performed successfully");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void testCase() {
        try {

            WebElement sourceElement = driver.findElement(By.id("draggable"));
            Actions actions = new Actions(driver);
            int getX = sourceElement.getLocation().getX();
            int getY = sourceElement.getLocation().getY();
            System.out.println("Source ele current location x,y co-ordinates" + getX + " " + getY);
            Actions dragAndDrop = actions.dragAndDropBy(sourceElement, 0, 50);
            dragAndDrop.perform();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        initialSetUp();
    }
}
