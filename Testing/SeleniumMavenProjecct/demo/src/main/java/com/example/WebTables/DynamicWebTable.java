package com.example.WebTables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTable {
    public static WebDriver driver = null;

    private static void initialSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/admin/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        testCase();
    }

    private static void testCase() {
        try {
            WebElement username_input = driver.findElement(By.name("username"));
            WebElement passsword_input = driver.findElement(By.name("password"));
            username_input.sendKeys("demo");
            passsword_input.sendKeys("demo");

            WebElement Login_button = driver.findElement(By.xpath("//button[@type='submit']"));
            Login_button.click();

            // Handle Bootstrap model Alert in selenium

            // Switch to active element here in our case its model dialogue box.
            driver.switchTo().activeElement();

            Thread.sleep(3000);

            // find the button which contains close
            driver.findElement(By.xpath("//button[@class='btn-close']")).click();

            // click on sales button
            WebElement sales_button = driver.findElement(By.id("menu-sale"));
            sales_button.click();
            WebElement orders_button = driver.findElement(By.xpath("//a[text()='Orders']"));
            orders_button.click();

            // Get total number pages available in pagination
            WebElement pages_count = driver.findElement(By.xpath("//div[contains(text(),'Pages')]"));
            String pages_counString = pages_count.getText();
            int totalPages = Integer.valueOf(
                    pages_counString.substring(pages_counString.indexOf("(") + 1, pages_counString.indexOf("P") - 1));
            System.out.println("Total Pages in Sales" + totalPages);

            // perform operation on Tableto get data
            // Get rows and colom count

            int coloum = driver.findElements(By.xpath("//table[contains(@class,'table')]//thead//td")).size();

            for (int page = 1; page <= totalPages; page++) {
                // For take One Row Down
                System.out.println();
                WebElement next_page = null;

                // For taking Active page No and Total rows on this page.....
                WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//li//span"));
                int rows = driver.findElements(By.xpath("//table[contains(@class,'table')]//tbody//tr")).size();
                System.out.println(
                        "Active Page is-->" + active_page.getText() + " Total Rows Available On Page Is-->" + rows);
                System.out.println();

                // For getting Data from table And Print On Console
                for (int rowCount = 1; rowCount <= rows; rowCount++) {
                    for (int coloumCount = 2; coloumCount < coloum; coloumCount++) {
                        String row_data = driver.findElement(By.xpath("//table[contains(@class,'table')]//tbody//tr["
                                + rowCount + "]//td[" + coloumCount + "]")).getText();
                        System.out.print(row_data + "   ");
                    }
                    System.out.println();
                }
                // Stop process for 2 Sec print dataon consol
                Thread.sleep(2000);

                String pageNo = Integer.toString(page + 1);
                if (page < totalPages) {
                    next_page = driver
                            .findElement(By.xpath("//ul[@class='pagination']//li//a[text()='" + pageNo + "']"));
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", next_page);
                }
                // For stop process for 1sec for change data on page after clicking next page.
                Thread.sleep(1000);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        initialSetUp();
    }

}
