package com.example.SelectClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * HandleJqueryDropDown
 */
public class HandleJqueryDropDown {
    public static WebDriver driver = null;

    public static void browserInitialSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");//
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement dropDownButton = driver.findElement(By.id("justAnInputBox"));
        dropDownButton.click();

       // selectOptions(driver, "All");
        selectOptions(driver, "choice 1","choice 2");

    }

    public static void selectOptions(WebDriver driver, String... value) {

        try {
            List<WebElement> dropdownList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
           
            if (value[0].equalsIgnoreCase("All")) {
                for (WebElement options : dropdownList) {
                    options.click();
                }
            } else {
                for (WebElement options : dropdownList) {
                    for (String userOption : value) {
                        if (options.getText().equals(userOption)) {
                            options.click();
                            break;
                        }

                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        browserInitialSetup();
    }
}