package com.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DesiredCapability {
    public static void main(String[] args) {

        // // Desired capabilty
        // DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        // capabilities.setCapability(CapabilityType.BROWSER_NAME, "CHROME");
        // //capabilities.setCapability(ChromeDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

        System.setProperty("webdriver.chrome.driver", "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(null)));
        String PageTitle = driver.getTitle();
        System.out.println(PageTitle);

    }
}
