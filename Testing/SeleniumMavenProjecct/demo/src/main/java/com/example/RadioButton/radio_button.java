package com.example.RadioButton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * radio_button
 */
public class radio_button {

    public static void main(String[] args) {
        WebDriver driver=null;
        try{
        System.setProperty("webdriver.chrome.driver", "/home/vaibhav/crome_driver/chromedriver_linux64/chromedriver");
         driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selenium08.blogspot.com/2019/08/radio-buttons.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement radioButtonYellow = driver.findElement(By.xpath("//input[@name='yellow' and @type='radio']"));
        radioButtonYellow.click();

        if(radioButtonYellow.isSelected()){
            System.out.println("Redio button yellow is succesfully selected");
        }

        WebElement radioButtonRed = driver.findElement(By.xpath("//input[@name='red' and @type='radio']"));
        radioButtonRed.click();

        WebElement radioButtonDhanbad = driver.findElement(By.xpath("//input[@name='Dhanbad' and @type='radio']"));
        radioButtonDhanbad.click();



        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            driver.close();
        }

    }
}