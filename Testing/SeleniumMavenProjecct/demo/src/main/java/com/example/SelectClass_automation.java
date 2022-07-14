package com.example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectClass_automation {

    private static WebDriver driver;

    public static void browserInitialSetup() {
        try {
            System.setProperty("webdriver.chrome.driver",
                    "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
            ChromeOptions co = new ChromeOptions();
            co.addArguments("--headless");

            driver = new ChromeDriver(co);
            driver.get("https://demoqa.com/select-menu");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            selectDropDownOptions();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
            driver.quit();
        }

    }

    public static void selectDropDownOptions() {
        WebElement selectbox = driver.findElement(By.xpath("//select[@name='cars']"));
        Select select = new Select(selectbox);
               
        if(selectbox.isDisplayed() && selectbox.isEnabled()){
            if (select.isMultiple()) {             
                List<WebElement> selectedValues = select.getOptions();
                for (WebElement element : selectedValues) {
                   if(element.getText().contains("Volvo") || element.getText().contains("Audi"))
                   {
                    select.selectByVisibleText("Volvo");
                    select.selectByVisibleText("Audi");
                    break;
                   }
                }
            }
        }
        
        List<WebElement>list = select.getAllSelectedOptions();
        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
        }

    }

    public static void main(String[] args) {
        browserInitialSetup();
       

    }

}
