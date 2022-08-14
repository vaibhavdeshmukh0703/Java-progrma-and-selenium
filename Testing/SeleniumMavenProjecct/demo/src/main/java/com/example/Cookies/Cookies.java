package com.example.Cookies;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies {
   public static void main(String[] args) {
    initialSetUp();
   }

private static void initialSetUp() {
    try {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            captureCookies(driver);
    } catch (Exception e) {
        //TODO: handle exception
    }
}

private static void captureCookies(WebDriver driver) {
    try {
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Totola Count oF Cookies "+cookies.size());

        //print all cookies

        for (Cookie cookie : cookies) {
           System.out.println(cookie.getName()+" "+cookie.getPath()+" "+cookie.getValue()); 
        }

        // How to add Cookie to browser
        Cookie c= new Cookie("vaibhav", "1234");
        driver.manage().addCookie(c);

      

       System.out.println(driver.manage().getCookieNamed("vaibhav"));

        
    } catch (Exception e) {
        //TODO: handle exception
    }
} 
}
