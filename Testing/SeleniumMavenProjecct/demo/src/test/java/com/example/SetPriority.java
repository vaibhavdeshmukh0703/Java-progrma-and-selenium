package com.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SetPriority {
    public WebDriver driver;
    // SetPriority(WebDriver driver){
    //     this.driver = driver;
    // }
    @BeforeSuite
    public void BrowserSetup() {

        System.out.println("Browser Setup is done");
    }
    @Test(priority = 1)
    public void LoginPage1() {
        System.out.println("Login is done 1");
    }
    @Test(priority = 2)
    public void LoginPage() {
        System.out.println("Login is done2");
    }
    @Test(priority = 3)
    public void LoginPage2() {
        System.out.println("Login is done3");
    }
@AfterSuite
    public void BrowserClose() {
        System.out.println("Browser Close sucesfully");
    }
}
