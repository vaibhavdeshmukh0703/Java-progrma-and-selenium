package com.demoblaze.pages.commanLibs;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommanDriver {

    private WebDriver driver = null;
    private WebDriverWait wait = null;
       
    public CommanDriver(String browserType) {

        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:
                try {
                    throw new Exception("Invalid Browser type : " + browserType);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }

      
    }

    public WebDriver getDriver(){
        return driver;
    }
    
    public void navigateToUrl(String url) {
        try{
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public String getTitle(){
        String title = driver.getTitle();
        return title;
    }

    public WebDriverWait getWait(){
        wait = new WebDriverWait(driver,5);
        return wait;
    }
    public String getPageSource(){
        return driver.getPageSource();
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
        
    }
    public String getWindowHandle(){
        return driver.getWindowHandle();
    }
     public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
     }
     
     

}
