package com.example.JavascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestJavascriptEcxecutor {
public static JavascriptExecutor js= null;
    public static void main(String[] args) {
    initialSetup();
   }

private static void initialSetup() {
    js = new FirefoxDriver();
    WebDriver driver = (WebDriver) js;
} 
}
