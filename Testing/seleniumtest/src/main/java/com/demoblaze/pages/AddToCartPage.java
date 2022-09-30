package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.pages.commanLibs.AlertControl;
import com.demoblaze.pages.commanLibs.ElementControl;
import com.demoblaze.pages.commanLibs.WaitControl;

public class AddToCartPage {
    ElementControl elementControl;
    WebDriver driver;
    @FindBy(linkText="Add to cart")
    WebElement Add_to_cart;

    WaitControl waitControl;
    AddToCartPage addToCartPage;
    AlertControl alertControl;
   public AddToCartPage(WebDriver driver){
        this.driver = driver;

        elementControl = new ElementControl();
         waitControl = new WaitControl(driver);
        addToCartPage = new AddToCartPage(driver);
        alertControl = new AlertControl(driver);
        PageFactory.initElements(driver,this);
   }
   
   public void addToCart(){
        elementControl.clickElement(Add_to_cart);
   }
   public  void waitForPageLoad(){
        waitControl.waitForElementLoad(Add_to_cart);
    }
    public void waitForAlertShow(){
        waitControl.waitForAlertShow();
    }
    public String getText(){
        return alertControl.getText();
    }
    public void handleAlert(){
        alertControl.dismissAlert();
    }


}
