package com.example.RadioButton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class check_redio_buuton_is_selected {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/vaibhav/crome_driver/chromedriver_linux64/chromedriver");
        WebDriver driver = null;

        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://selenium08.blogspot.com/2019/08/radio-buttons.html");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement redioButtonGreen = driver.findElement(By.xpath("//input[@name='green' and @type='radio']"));
            if(redioButtonGreen.isEnabled() && redioButtonGreen.isDisplayed()){
                System.out.println("Button Is Unable");               
            }
            System.out.println("Button Is Not Unable");
            if(!redioButtonGreen.isSelected()){
                redioButtonGreen.click();
                if(redioButtonGreen.isDisplayed()){
                    redioButtonGreen.click();
                }
            }


        }catch(

    Exception e)
    {
        // TODO: handle exception
        System.out.println(e.getMessage());
    }
}}
