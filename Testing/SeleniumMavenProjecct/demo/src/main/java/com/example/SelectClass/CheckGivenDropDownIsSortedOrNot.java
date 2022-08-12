package com.example.SelectClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckGivenDropDownIsSortedOrNot {
    public static WebDriver driver = null;

    public static void initialSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in");//
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement amazonSelectBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        amazonSelectBox.click();

        Select select = new Select(amazonSelectBox);

        List<WebElement> amazonSelectBoxOptions = select.getOptions();

        // If you want to make copy of LIST you cant directly assign to another
        // You need to create one ArrayList and add item from LIST to ArrayList using
        // for loop over LIST

        ArrayList<String> originalList = new ArrayList<String>();
        ArrayList<String> tempList = new ArrayList<String>();

        for (WebElement option : amazonSelectBoxOptions) {
            originalList.add(option.getText());
            tempList.add(option.getText());
        }

        Collections.sort(tempList);

        if (originalList.equals(tempList)) {
            System.out.println("Drop down List is in sorted order");
        } else {
            System.out.println("List is non sorted");
        }

    }

    public static void main(String[] args) {
        initialSetUp();
    }
}
