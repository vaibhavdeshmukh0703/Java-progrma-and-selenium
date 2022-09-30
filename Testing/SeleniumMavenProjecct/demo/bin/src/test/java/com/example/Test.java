package com.example;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) {
		preSetUp();// Wake up browser with app URL
		setUp(); // LOgin to Application
		selectItem("Phones", "Samsung galaxy s6"); // Select Item to insert in to cart
		selectItem("Laptops", "Dell i7 8gb");
		selectItem("Monitors", "ASUS Full HD");
		// get element from cart
		displayCart();

	}

	private static void displayCart() {
		try {
			driver.findElement(By.linkText("Cart")).click();
			Thread.sleep(3000);

			List<WebElement> columnData = driver.findElements(By.xpath("//table//thead//th"));
			int columns = columnData.size();

			List<WebElement> rowsData = driver.findElements(By.xpath("//table//tbody//tr"));
			int rows = rowsData.size();
			int totalCost = 0;
			for (int row = 1; row <= rows; row++) {
				for (int column = 1; column < columns; column++) {
					String data = driver.findElement(By.xpath("//table//tbody//tr[" + row + "]//td[" + column + "]"))
							.getText();
					System.out.print(data + " ");
					if (column == 3) {
						totalCost = totalCost + Integer.parseInt(data);
					}

				}
				System.out.println();
			}
			int appTotalValue = Integer.parseInt(driver.findElement(By.id("totalp")).getText());
			System.out.println(totalCost + "   " + appTotalValue);
			if (totalCost == appTotalValue) {
				System.out.println("Correct Value");
			} else {
				System.out.println("Incorrect value");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void selectItem(String category, String item) {
		try {
			// refersh the web page

			category.trim();
			driver.navigate().refresh();

			// click on the home and the Phones Link
			driver.findElement(By.xpath("//a[text()='Home ']")).click();
			driver.findElement(By.linkText(category)).click();

			// Select item from list
			driver.findElement(By.linkText(item)).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));
			driver.findElement(By.linkText("Add to cart")).click();

			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.dismiss();

			// selectItem(String category, String item)

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void setUp() {
		try {

			driver.findElement(By.linkText("Log in")).click();
			driver.switchTo().activeElement();
			driver.findElement(By.id("loginusername")).sendKeys("vaibhav1");
			driver.findElement(By.id("loginpassword")).sendKeys("vaibhav@123");
			driver.findElement(By.xpath("//button[text()='Log in']")).click();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}

	private static void preSetUp() {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://demoblaze.com/index.html");
			String title = driver.getTitle();
			System.out.println(title);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
