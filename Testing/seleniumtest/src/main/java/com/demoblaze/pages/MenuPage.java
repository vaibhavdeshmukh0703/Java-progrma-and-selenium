package com.demoblaze.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.pages.commanLibs.ElementControl;

public class MenuPage {

    ElementControl elementControl = null;
   
    @FindAll({
        @FindBy(partialLinkText ="Home"),
        @FindBy(partialLinkText ="Contact"),
        @FindBy(partialLinkText ="About us"),
        @FindBy(partialLinkText ="Cart"),
        @FindBy(partialLinkText ="Log in"),
        @FindBy(partialLinkText ="Sign up"),
        @FindBy(partialLinkText ="Log out"),
        @FindBy(partialLinkText ="Welcome"),
    })

    
    List<WebElement> listOFMenus;

     public MenuPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void selectMenuItem(String name){

        for (WebElement webElement : listOFMenus) {
         // System.out.println(webElement.getText());
         
            if(name.trim().toLowerCase() == webElement.getText().toLowerCase()){
                elementControl.clickElement(webElement);;
            }
        }
    }
}
