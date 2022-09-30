package com.demoblaze.pages.commanLibs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitControl {
    WebDriver driver;
    WebDriverWait ww;
    public WaitControl(WebDriver driver){
         ww = new WebDriverWait(driver,4);
    }
    
    public String waitForElementLoad_getText(WebElement element){
      return  ww.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void waitForElementLoad(WebElement element){
        ww.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForAlertShow(){
        ww.until(ExpectedConditions.alertIsPresent());
    }

}
