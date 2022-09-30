package com.demoblaze.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.pages.commanLibs.ElementControl;
import com.demoblaze.pages.commanLibs.WaitControl;

public class LoginPage {
    WebDriver driver;

    ElementControl elementControl;
    WaitControl waitControl;

    @FindBy(linkText = "Log in")
    private WebElement signInLink;

    @FindBy(id = "loginusername")
    private WebElement userNameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(partialLinkText = "Welcome")
    private WebElement WelcomeMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        elementControl = new ElementControl();
        waitControl = new WaitControl(driver);

        PageFactory.initElements(driver, this);
    }

    public void navigateToLoginUrl() {
        try {
            elementControl.clickElement(signInLink);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void signIn(String userName, String password) {
        try {
            elementControl.sendInput(userNameField, userName);
            elementControl.sendInput(passwordField, password);
            elementControl.clickElement(loginButton);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String waitForWelcomeMessage(){
        return waitControl.waitForElementLoad_getText(WelcomeMessage);
    }

}
