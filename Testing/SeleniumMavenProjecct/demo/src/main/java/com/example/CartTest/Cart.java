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


public class Cart {
    private static WebDriver driver = null;

    public static void initialSetUp() {
        try {
            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
            driver.get("http://demoblaze.com/index.html");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            loginToDemoBlaze();
            moveToCart();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }

    private static void loginToDemoBlaze() {
        try {
            selectElementByLinkText("Log in");
            driver.switchTo().activeElement();

            sendKeysData("loginusername", "sctqaautomation@grr.la");
            sendKeysData("loginpassword", "Spring@123");
            selectElementByXpath("//button[text()='Log in']");

        } catch (Exception e) {
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

    public static void selectElementByXpath(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void moveToCart() {
        try {

            WebDriverWait ww = new WebDriverWait(driver, 3);
           
            driver.navigate().refresh();
            selectElementByXpath("//a[text()='Home ']");
            selectElementByLinkText("Phones");

            selectElementByLinkText("Samsung galaxy s6");

          
            ww.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));
            selectElementByLinkText("Add to cart");

            // Handle Alert--->
            ww.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.dismiss();

            // Back To HOme Page

             driver.navigate().refresh();
             selectElementByXpath("//a[text()='Home ']");

            // -------------------------------Code For Laptop
            // Section--------------------------

            selectElementByLinkText("Laptops");

            selectElementByLinkText("Dell i7 8gb");

            ww.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));

            selectElementByLinkText("Add to cart");

            ww.until(ExpectedConditions.alertIsPresent());
            alert.dismiss();

            // Back To HOme Page
            driver.navigate().refresh();
             selectElementByXpath("//a[text()='Home ']");

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

            // ---------------------------------- Operation Cart--------------------------

            selectElementByLinkText("Cart");

            ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));

            List<WebElement> columnData = driver.findElements(By.xpath("//table//thead//tr//th"));
            int columns = columnData.size();

            List<WebElement> rowsData = driver.findElements(By.xpath("//table//tbody//tr"));
            int rows = rowsData.size();

            int totalAmount = 0;
            for (int row = 1; row <= rows; row++) {
                for (int column = 2; column <= columns - 1; column++) {
                    String data = driver.findElement(By.xpath("//table//tbody//tr[" + row + "]//td[" + column + "]"))
                            .getText();
                    System.out.print(data + " ");
                    if (column == 3) {
                        totalAmount = totalAmount + Integer.parseInt(data);
                    }
                }
                System.out.println();
            }
            System.out.println("total amount ->" + totalAmount);

            Thread.sleep(3000);

            // Check the given total are same or not
            WebElement total = driver.findElement(By.id("totalp"));
            int systemTotalAmount = Integer.parseInt(total.getText());
            if (totalAmount == systemTotalAmount) {
                System.out.println("Calculated Amount is Correct");
            } else {
                System.out.println("Invalid Amount");
            }
            // System.out.println(" Total Amount is --->"+totalAmount+ " Actual Total amount
            // -->"+actualTotal);

            WebElement placeOrder = driver.findElement(By.xpath("//button[text()='Place Order']"));
            placeOrder.click();

            // ----------------Operation Place
            // Order-----totalp----------------------------------

            driver.switchTo().activeElement();

            sendKeysData("name", "chetan");

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

            // System.out.println(data);
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