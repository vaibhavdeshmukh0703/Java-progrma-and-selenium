package com.example.CartTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Cart
 */
public class Cart {
    private static WebDriver driver = null;

    public static void initialSetUp() {
        try {
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
            driver.get("http://demoblaze.com/index.html");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            moveToCart();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }

    public static void selectElementByLinkText(String link) {
        try {
            WebElement element = driver.findElement(By.linkText(link));
            element.click();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void selectElementById(String id) {
        try {
            WebElement element = driver.findElement(By.id(id));
            element.click();
        } catch (Exception e) {
            e.printStackTrace(); // TODO: handle exception
        }
    }

    public static void sendKeysData(String id, String inputValue) {
        try {
            WebElement element = driver.findElement(By.id(id));
            element.sendKeys(inputValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void moveToCart() {
        try {

            selectElementByLinkText("Samsung galaxy s6");

            WebDriverWait ww = new WebDriverWait(driver, 3);
            ww.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));

            selectElementByLinkText("Add to cart");

            // Handle Alert--->
            ww.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.dismiss();

            // Back To HOme Page

            selectElementById("nava");

            // -------------------------------Code For Laptop
            // Section--------------------------

            selectElementByLinkText("Laptops");

            selectElementByLinkText("Dell i7 8gb");

            ww.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));

            selectElementByLinkText("Add to cart");

            ww.until(ExpectedConditions.alertIsPresent());
            alert.dismiss();

            // Back To HOme Page

            selectElementById("nava");

            // ----------------------------------For Web Element MOnitor_----------->

            // Click On laptop Option Laptops

            selectElementByLinkText("Monitors");

            selectElementByLinkText("ASUS Full HD");

            ww.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));

            selectElementByLinkText("Add to cart");

            // Handle Alert--->
            ww.until(ExpectedConditions.alertIsPresent());
            alert.dismiss();

            // Back To HOme Page

            selectElementById("nava");

            // ---------------------------------- Operation Cart--------------------------

            selectElementByLinkText("Cart");

            ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

            List<WebElement> tableData = driver.findElements(By.xpath("//table//tbody//tr"));

            for (WebElement element : tableData) {
                System.out.println(element.getText());
            }

            WebElement placeOrder = driver.findElement(By.xpath("//button[text()='Place Order']"));
            placeOrder.click();

            // ----------------Operation Place Order---------------------------------------

            driver.switchTo().activeElement();

            sendKeysData("name", "vaibhav");

            sendKeysData("country", "India");

            sendKeysData("city", "Pune");

            sendKeysData("card", "123456789");

            sendKeysData("month", "september");

            sendKeysData("year", "2022");

            WebElement purchaseButton = driver.findElement(By.xpath("//button[text()='Purchase']"));
            purchaseButton.click();

            // ------------------------------Operation Get Order
            // Details-------------------------

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String script = " return document.getElementsByClassName('lead text-muted').item(0).getInnerHTML()";
            String data = (String) js.executeScript(script);

            System.out.println(data);
            String[] spliteResult = data.split("<br>");
            System.out.println("Order ID Is -- " + spliteResult[0] + " And Order Amount is --" + spliteResult[1]);

            Thread.sleep(2000);

            String scriptForOKButton = "document.getElementsByClassName('confirm btn btn-lg btn-primary').item(0).click()";
            js.executeScript(scriptForOKButton);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                driver.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        initialSetUp();
    }
}