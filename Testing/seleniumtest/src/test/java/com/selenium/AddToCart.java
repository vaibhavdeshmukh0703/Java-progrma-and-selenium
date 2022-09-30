package com.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.demoblaze.pages.AddToCartPage;
import com.demoblaze.pages.commanLibs.AlertControl;
import com.demoblaze.pages.commanLibs.ElementControl;
import com.demoblaze.pages.commanLibs.WaitControl;

public class AddToCart {

    WebDriver driver;
    AddToCartPage addToCartPage;

    public AddToCart(WebDriver driver) {
        addToCartPage = new AddToCartPage(driver);
        this.driver = driver;

    }

    @Test(priority=2)
    public void AddTOCart() {


        waitForPageLoad();
        addToCart();
        waitForAlertShow();
    String text = getTextFromAlert();
        dismissAlert();
       Assert.assertEquals(text, "Product added");

    }

    private void waitForPageLoad() {
        addToCartPage.waitForPageLoad();
    }
    private void addToCart(){
        addToCartPage.addToCart();
    }
    private void waitForAlertShow(){
        addToCartPage.waitForAlertShow();
    }
    private String getTextFromAlert(){
       return addToCartPage.getText();
    }
    private void dismissAlert(){
        addToCartPage.handleAlert();
    }

}
