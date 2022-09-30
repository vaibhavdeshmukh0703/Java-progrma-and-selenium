package com.demoblaze.pages.commanLibs;

import org.openqa.selenium.WebDriver;

public class SwitchToActiveElementControl {
    public SwitchToActiveElementControl(WebDriver driver){
        driver.switchTo().activeElement();
    }   

}
