package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
Scenario to Automate:

1. Launch the web browser.
2. Open the URL https://www.facebook.com in the current browser.
3. Fetching home page title.
4. Verify actual tile of the home page with the expected title.
5. Print home page title on the console.
6. Close the browser.
 * 
 * 
 */
public class Senario1 {
   public static void main(String[] args) {
     try {
         // Lounch web Driver
      System.setProperty("webdriver.chrome.driver", "/home/vaibhav/crome_driver/chromedriver_linux64/chromedriver");
      WebDriver driver = new ChromeDriver();

      // Open the URL https://www.facebook.com in the current browser.
      driver.get("http://www.facebook.com");
   
      //Fetching home page title.
      String homePageTitle = driver.getTitle();
      
      //Verify actual tile of the home page with the expected title.
      String actualTitle = "Facebook – log in or sign up";

      if(actualTitle.equalsIgnoreCase(homePageTitle)){
         System.out.println("Title of the home page is ->"+homePageTitle);
      }
      else{
      System.out.println("Incorrect Home Page Title");
      }

      //Close the broeser.
      driver.close();

    

     } catch (Exception e) {
        System.out.println(e.getMessage());
   } 
}
}
