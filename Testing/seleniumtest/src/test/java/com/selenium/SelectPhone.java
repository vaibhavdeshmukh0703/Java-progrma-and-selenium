package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import com.demoblaze.pages.AddToCartPage;
import com.demoblaze.pages.CategoryPage;
import com.demoblaze.pages.MenuPage;
import com.demoblaze.pages.PhonesPage;
import com.demoblaze.pages.commanLibs.AlertControl;
import com.demoblaze.pages.commanLibs.ElementControl;
import com.demoblaze.pages.commanLibs.NavigationControl;
import com.demoblaze.pages.commanLibs.WaitControl;

public class SelectPhone extends BaseTest {
    WebDriver driver;

    MenuPage menuPage;
    WaitControl waitControl;
    CategoryPage categoryPage;
    ElementControl elementControl;
    PhonesPage phonesPage;
    NavigationControl navigationControl;
    AlertControl alertControl;
    
    AddToCartPage addToCart;
    
    public SelectPhone(WebDriver driver) {
        this.driver = driver;
        menuPage = new MenuPage(driver);
        categoryPage = new CategoryPage(driver);
        phonesPage = new PhonesPage(driver);
        navigationControl = new NavigationControl(driver);
        addToCart = new AddToCartPage(driver);

    }

    @Test()
    public void selectSamsungGalaxtS6() {
        try {
           // driver.navigate().refresh();
            refreshPage();
            Thread.sleep(1000);
            selectHomePage("home");
            selectCategory("Phones");

            waitForLoadElement("Samsung galaxy s6");
            clickOnPhone("Samsung galaxy s6");

            waitForPageLoad();
            addToCart();
            waitForAlertShow();
            handleAlert();
            Assert.assertTrue(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void waitForAlertShow() {
       waitControl.waitForAlertShow();
    }

    private void handleAlert() {
        alertControl.dismissAlert();
    }

    private void waitForPageLoad() {
        addToCart.waitForPageLoad();
    }

    private void addToCart() {

    }

    private void refreshPage() {
        navigationControl.doRefreshPage();
    }

    private void clickOnPhone(String nameOfPhone) {
        phonesPage.selectPhone(nameOfPhone);
    }

    private void waitForLoadElement(String name) {
        phonesPage.waitForElementLoad(name);
    }

    private void selectCategory(String name) {
        try {
            categoryPage.selectCategory(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void selectHomePage(String nameOfMenu) {
        menuPage.selectMenuItem(nameOfMenu);
    }
}
