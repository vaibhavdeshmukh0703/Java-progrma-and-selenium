package com.example.ToolTip;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {
    public static void main(String[] args) {
        initialSetUp();
    }

    private static void initialSetUp() {

        try {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.jqueryui.com/tooltip");

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            String title = driver.getTitle();
            System.out.println("web page title is " + title);
            toolTipMethod(driver);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    private static void toolTipMethod(WebDriver driver) {
        try {
            driver.switchTo().frame(0);
            WebElement tooltip = driver.findElement(By.linkText("Tooltips"));
            String toolTipMsg = tooltip.getAttribute("title");
            System.out.println(toolTipMsg);
           
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
