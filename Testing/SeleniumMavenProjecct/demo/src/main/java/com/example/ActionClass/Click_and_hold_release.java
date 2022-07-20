package com.example.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Click_and_hold_release {
    private static WebDriver driver =null;
    public static void initialSetUp(){
    try {
        System.setProperty("webdriver.chrome.driver", "/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String PageTitle = driver.getTitle();
        System.out.println(PageTitle);

        TestCase();
    } catch (Exception e) {
        //TODO: handle exception
        System.out.println(e.getMessage());
    }//finally{
    //     try {
    //         //driver.close();
    //     } catch (Exception e) {
    //         //TODO: handle exception
    //         System.out.println(e.getMessage());
    //     }
    // }
    }

    public static void TestCase(){
        
        try{
            WebElement Button_A = driver.findElement(By.xpath("//li[text()='A']"));
            WebElement Button_C = driver.findElement(By.xpath("//li[text()='C']"));
            int getX_ButtonC = Button_C.getLocation().getX();
            int getY_ButtonC = Button_C.getLocation().getY();

            int getX_Button_A = Button_A.getLocation().getX();
            int getY_Button_A = Button_A.getLocation().getY();

            System.out.println(getX_Button_A+" ---- "+getY_Button_A);
            System.out.println(getX_ButtonC+"------"+getY_ButtonC);
            Actions actions =  new Actions(driver);
            actions.clickAndHold(Button_A).moveByOffset(218,0).perform();
          //  actions.clickAndHold(Button_A).moveByOffset(getX+1,getY+1).perform();

            //actions.moveToElement(Button_C).release().perform();


        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        initialSetUp();
    }
    
}
