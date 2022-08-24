package com.example.CheckBox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.example.Xpath_Starts_with;

import org.apache.commons.math3.util.MultidimensionalCounter.Iterator;
import org.bouncycastle.jcajce.provider.asymmetric.ElGamal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import freemarker.log.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectCheckBox {
   public static void main(String[] args) {
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.get("https://itera-qa.azurewebsites.net/home/automation");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      // Select Button Where ?
      handleCheckBoxes(driver);
      handleRadioButton(driver);
   }

   private static void handleRadioButton(WebDriver driver) {
      List<WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@id, 'male')]"));
      for(WebElement radioButton : radioButtons){
         String radioButtonName = radioButton.getAttribute("id");
         if(!radioButton.isSelected() && radioButton.isEnabled() && radioButtonName.equals("male"))
         {
            radioButton.click();
         }
      }
   }

   private static void handleCheckBoxes(WebDriver driver) {
      List<WebElement> checkboxs = driver.findElements(By.xpath("//input[contains(@id, 'day')]"));
      
      for (WebElement element : checkboxs) {
         String checkBoxName = element.getAttribute("id");
         
         //System.out.println(checkBoxName);
         if(checkBoxName.equalsIgnoreCase("Monday") || checkBoxName.equalsIgnoreCase("Sunday")){
            element.click();
      
         }
      }
       java.util.Iterator<WebElement> it = checkboxs.iterator();
      while(it.hasNext()){
         String checkBoxName = it.next().getAttribute("id");
         System.out.println(checkBoxName);
      } 

   }
}
