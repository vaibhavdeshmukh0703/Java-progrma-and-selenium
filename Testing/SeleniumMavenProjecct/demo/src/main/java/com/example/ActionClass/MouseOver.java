package com.example.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseOver {
    private static WebDriver driver = null;
    public static void initialSetup() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");

			// ChromeOptions co = new ChromeOptions();
			// co.addArguments("--headless");

			driver = new ChromeDriver();

			//driver.get("https://www.zilti.com");
         driver.get("http://www.amazon.in");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			
			mouseOverMethod();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
    private static void mouseOverMethod() {
		WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
		System.out.println(accountList.getText());
		Actions action = new Actions(driver);
		Actions accountListMouseOver = action.moveToElement(accountList);
		accountListMouseOver.perform(); 

		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a//span[text()='Your Orders']")));

		WebElement yourOrders = driver.findElement(By.xpath("//a//span[text()='Your Orders']"));
		Action yourOrdersElementClick =
		 action.click(yourOrders).build();
		yourOrdersElementClick.perform();



    }
    public static void main(String[] args) {
        initialSetup();
    }    
}
