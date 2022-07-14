package com;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.;
/**
 * Scenario to be automated:

1. Open webpage “https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html“.

2. Locate checkbox elements “Red”, “Blue”, and “Orange”, and click on them for selecting.

Let’s write the source code for this scenario.
 * 
 */
public class CheckBoxSelection {
  
         
       static WebDriver driver = null;
        @BeforeClass
        private static void setup(){
            try {
                System.setProperty("webdriver.chrome.driver", "/home/vaibhav/crome_driver/chromedriver_linux64/chromedriver");
                String URL = "https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html"; 
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get(URL);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public static void assertTrue(){
        try {
            WebElement redCheckBoxElement = driver.findElement(By.xpath("//input[@name='color' and @value='red']"));
            redCheckBoxElement.click();

            WebElement blueCheckBoxElement = driver.findElement(By.xpath("//input[@name='color' and @value='blue']"));
            blueCheckBoxElement.click();

             WebElement orangeCheckBoxElement = driver.findElement(By.xpath("//input[@name='color' and @value='orange']"));
            orangeCheckBoxElement.click();

          //  Assert.assertTrue();
            if(redCheckBoxElement.isSelected() && blueCheckBoxElement.isSelected() && orangeCheckBoxElement.isSelected()){
                System.out.println(" All Checkbox is selected");
            }

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
       
@AfterMethod
public static void aferMethod(){
    driver.close();
}    
    public static void main(String[] args) {
        setup();
        assertTrue();
        aferMethod();
    }

    
}
