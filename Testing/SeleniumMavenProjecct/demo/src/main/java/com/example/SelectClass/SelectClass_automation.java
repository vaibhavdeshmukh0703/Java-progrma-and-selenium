package com.example.SelectClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

            WebElement selectbox = driver.findElement(By.xpath("//select[@name='cars']"));
            String[] forSelectOption = { "Volvo", "Audi" };
            selectDropDownOptions(selectbox, forSelectOption);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            driver.quit();
        }

    }

    public static void selectDropDownOptions(WebElement SelectBox, String[] values) {

        Select select = new Select(SelectBox);

        if (SelectBox.isDisplayed() && SelectBox.isEnabled()) {
            if (select.isMultiple()) {
                selectOption(select, values);
            }else{
                selectOption(select, values);
            }
        }

        List<WebElement> list = select.getAllSelectedOptions();
        for (WebElement webElement : list) {
            System.out.println(webElement.getText());
        }

    }

    private static void selectOption(Select select, String[] values) {
        List<WebElement> selectedValues = select.getOptions();
                for (WebElement element : selectedValues) {
                    for (String option : values) {
                        if (element.getText().equals(option)) {
                            select.selectByVisibleText(option);
                            break;
                        }
                    }

                }
    }

    public static void main(String[] args) {
        browserInitialSetup();
    }
}
