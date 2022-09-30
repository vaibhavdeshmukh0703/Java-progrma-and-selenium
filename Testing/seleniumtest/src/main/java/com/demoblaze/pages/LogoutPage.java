package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.pages.commanLibs.ElementControl;

public class LogoutPage {
    ElementControl elementControl = null;

    @FindBy(linkText = "Log out")
    WebElement logout;

    public LogoutPage(WebDriver driver) {
        elementControl = new ElementControl();
        PageFactory.initElements(driver, this);
    }

    public void signOut() {
        try {
            elementControl.clickElement(logout);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
