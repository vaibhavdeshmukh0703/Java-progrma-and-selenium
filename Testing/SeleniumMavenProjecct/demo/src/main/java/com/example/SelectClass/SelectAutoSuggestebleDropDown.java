package com.example.SelectClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.javadoc.internal.doclets.formats.html.markup.Text;

public class SelectAutoSuggestebleDropDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.airbnb.co.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Select Button Where ?
        handleAutoSuggestibleDropDown(driver);
    }

    private static void handleAutoSuggestibleDropDown(WebDriver driver) {
        try {
            WebElement buttonWebElement = driver.findElement(By.xpath("//button//div[text()='Anywhere']"));
            buttonWebElement.click();

            WebElement queryInputBox = driver.findElement(By.xpath("//input[@name='query']"));
            queryInputBox.sendKeys("Torento");

            String inputValue;
            do {
                queryInputBox.sendKeys(Keys.ARROW_DOWN);
                inputValue = queryInputBox.getAttribute("value");
                if (inputValue.equals("Torino, Italy")) {
                    queryInputBox.sendKeys(Keys.ENTER);
                    break;
                }

            } while (!inputValue.isEmpty());

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
