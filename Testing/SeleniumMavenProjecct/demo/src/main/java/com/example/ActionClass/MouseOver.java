package com.example.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

    }
    public static void main(String[] args) {
        initialSetup();
    }    
}
