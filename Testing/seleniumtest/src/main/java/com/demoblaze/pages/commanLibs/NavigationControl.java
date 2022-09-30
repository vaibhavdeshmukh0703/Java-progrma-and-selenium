package com.demoblaze.pages.commanLibs;

import org.openqa.selenium.WebDriver;

public class NavigationControl {
    //driver.navigate.refresh()
    WebDriver driver;
  
     public NavigationControl(WebDriver driver){
        this.driver = driver;

    }

    public void doRefreshPage(){
        driver.navigate().refresh();
    }

}
