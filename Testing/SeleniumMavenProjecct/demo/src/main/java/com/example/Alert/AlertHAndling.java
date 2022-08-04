package com.example.Alert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHAndling {
	private static WebDriver driver = null;

	public static void initialSetup() {
		try {
			WebDriverManager.chromedriver().setup();

			ChromeOptions co = new ChromeOptions();
			co.addArguments("--headless");

			driver = new ChromeDriver();

			driver.get("https://selenium08.blogspot.com/2019/07/alert-test.html");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			 handleSimpleAlert();
			// handleConfirmationAlert();
			//handlePromptAlertBox();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		finally{
			driver.quit();
		}
	}

	private static void handlePromptAlertBox() {
		try {
			WebElement promptBox = driver.findElement(By.id("prompt"));
			promptBox.click();

			WebDriverWait ww = new WebDriverWait(driver, 5);
			ww.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			String getText = alert.getText();

			if (getText.equalsIgnoreCase("Please enter your name")) {
				alert.sendKeys("Vaibhav");
				alert.accept();
				System.out.println("Alert accepted succesfully");
			} else {
				alert.dismiss();
				System.out.println("Alert dismiss");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//driver.quit();
		}

	}

	public static void handleConfirmationAlert() {

		try {
			WebElement confirmationAlertBox = driver.findElement(By.id("confirm"));
			confirmationAlertBox.click();

			WebDriverWait ww = new WebDriverWait(driver, 5);
			ww.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			String getText = alert.getText();

			if (getText.equalsIgnoreCase("This is a confirm alert. Do you want to accept or cancel?")) {
				 alert.sendKeys("Welcome");
				alert.accept();
				System.out.println("alert Cofirmation accepted");
			} else {
				alert.dismiss();
				System.out.println("Alert Confirmation is cancled");
			}
		} catch (Exception e) {
			driver.quit();
			System.out.println(e.getMessage());
		}

	}

	public static void handleSimpleAlert() {
		try {
			WebElement simpleAlert = driver.findElement(By.id("simple"));
			simpleAlert.click();

			WebDriverWait ww = new WebDriverWait(driver, 5);
			ww.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();

			String getText = alert.getText();
			if (getText.equalsIgnoreCase("Hello! I am a simple alert box!")) {
				Thread.sleep(2000);
				alert.accept();
				System.out.println("Its correct masseage");
			} else {
				System.out.println("Something Wrong!!! ----> original msg" + getText);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialSetup();
	}

}
