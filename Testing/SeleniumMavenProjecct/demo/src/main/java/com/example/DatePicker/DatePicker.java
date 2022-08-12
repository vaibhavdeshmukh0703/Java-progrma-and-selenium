package com.example.DatePicker;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
    private static WebDriver driver = null;

    private static void initialSetUp() {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.redbus.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            testCaseForDatePicker();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    private static void testCaseForDatePicker() {
        try {
            String day = "13";
            String month = "November";
            String year = "2022";

            // For take WebElement Date
            WebElement dateWebElement = driver.findElement(By.id("date-box"));
            dateWebElement.click();

            while (true) {

                // gettting Month and year from date Picker

                List<WebElement> datePickerMonthAndYear = driver.findElements(
                        By.xpath("//div[@style='flex-grow: 5; font-size: 18px; font-weight: 700;']"));
                String firstDatePickerMonthAndYear = datePickerMonthAndYear.get(0).getText();
                String secondDatePickerMonthAndYear = datePickerMonthAndYear.get(1).getText();
                // System.out.println(firstDatePickerMonthAndYear+"
                // "+secondDatePickerMonthAndYear);

                // for splite firstDatePickerMonthAndYear
                String[] spliteFirstDatePickerMonthAndYear = firstDatePickerMonthAndYear.split(" ");
                String monthOfFirstDatePickerMonthAndYear = spliteFirstDatePickerMonthAndYear[0];
                String yearOfFirstDatePickerMonthAndYear = spliteFirstDatePickerMonthAndYear[1];

                // for Splite SecondDatePickerMonthAndYear
                String[] spliteSecondDatePickerMonthAndYear = secondDatePickerMonthAndYear.split(" ");
                String monthOfSecondDatePickerMonthAndYear = spliteSecondDatePickerMonthAndYear[0];
                String yearOfSecondDatePickerMonthAndYear = spliteSecondDatePickerMonthAndYear[1];

                if ((month.equalsIgnoreCase(monthOfFirstDatePickerMonthAndYear)
                        && year.equalsIgnoreCase(yearOfFirstDatePickerMonthAndYear))) {

                    WebElement selectDatePickerDate = driver.findElement(By.xpath("(//span[text()='" + day + "'])[1]"));
                    selectDatePickerDate.click();
                    break;
                } else if (month.equalsIgnoreCase(monthOfSecondDatePickerMonthAndYear)
                        && year.equalsIgnoreCase(yearOfSecondDatePickerMonthAndYear)) {

                    WebElement selectDatePickerDate = driver.findElement(By.xpath("(//span[text()='" + day + "'])[2]"));
                    selectDatePickerDate.click();
                    break;
                } else {
                    WebElement nextClick = driver.findElement(By.xpath("//*[local-name()='svg' and @height='16']"));
                    nextClick.click();
                    Thread.sleep(2000);
                }
            }

        } catch (

        Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        initialSetUp();
    }

}
