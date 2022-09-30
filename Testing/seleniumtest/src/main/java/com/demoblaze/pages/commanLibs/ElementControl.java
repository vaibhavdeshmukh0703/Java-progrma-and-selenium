package com.demoblaze.pages.commanLibs;

import org.openqa.selenium.WebElement;

public class ElementControl {
    public ElementControl(){
        // Constructor
    }  
    
    public void clickElement(WebElement element){
        element.click();
    }

    public void sendInput(WebElement element, String input){
        element.sendKeys(input);
    }
    
    public String getText(WebElement element){
        return element.getText();
    }

    public void clearText(WebElement element){
        element.clear();
    }


}
