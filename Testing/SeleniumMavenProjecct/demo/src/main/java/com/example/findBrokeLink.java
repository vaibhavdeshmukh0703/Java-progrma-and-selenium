package com.example;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class findBrokeLink {
  private static WebDriver driver = null;
  private static HttpURLConnection huc = null;
   public static void initialSetup() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");

			ChromeOptions co = new ChromeOptions();
			co.addArguments("--headless");

			driver = new ChromeDriver();

			//driver.get("https://www.zilti.com");
         driver.get("http://www.amazon.in");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			
			findBrokenLinks();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
   public static void findBrokenLinks(){
      try{
      List <WebElement> ancorTag = driver.findElements(By.tagName("a"));

        for (WebElement webElement : ancorTag) {
       if(webElement.getAttribute("href")==null ||  webElement.getAttribute("href").isEmpty()){
          System.out.println("Url is empty");
         continue;
       }
       else{
          String url = webElement.getAttribute("href");
         huc = (HttpURLConnection)(new URL(webElement.getAttribute("href")).openConnection());
         huc.connect();
         int responceCode = huc.getResponseCode();
         if(responceCode>=400){
            System.out.println(url+"---->"+huc.getResponseMessage()+"is a broken Link");
         }
         else{
            System.out.println("from ElseCode"+url+"-------->"+huc.getResponseMessage());
         }
       }
    }
        
   }catch(Exception e){
      System.out.println(e.getMessage());
   }
 
     
   }
    
   public static void main(String[] args) {
     initialSetup(); 
   } 
}
