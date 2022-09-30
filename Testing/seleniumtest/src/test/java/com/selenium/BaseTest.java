package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.demoblaze.pages.LoginPage;
import com.demoblaze.pages.LogoutPage;
import com.demoblaze.pages.MenuPage;
import com.demoblaze.pages.PhonesPage;
import com.demoblaze.pages.commanLibs.CommanDriver;
import com.demoblaze.pages.commanLibs.SwitchToActiveElementControl;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    WebDriver driver;
    WebDriverWait ww = null;

    // Utility Classes declaration
    LoginPage loginPage;
    LogoutPage logoutPage;
    CommanDriver commandriver;
    SwitchToActiveElementControl switchToActiveElement;
    Alert alert;
    PhonesPage phonesPage;
    MenuPage menuPage;
    SelectPhone selectPhone;

    @BeforeClass
    public void preSetUp() {
        try {

            openBrowser("chrome");
            getDriverInstance();

            loginPage = new LoginPage(driver);
            phonesPage = new PhonesPage(driver);
            menuPage = new MenuPage(driver);
            logoutPage = new LogoutPage(driver);
            selectPhone = new SelectPhone(driver);

            String url = "http://www.demoblaze.com/index.html";
            sendUrlToBrowserOpening(url);
            String webPageName = getPageTitle();

            Assert.assertEquals("STORE", webPageName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getPageTitle() {
        return commandriver.getTitle();
    }

    private void sendUrlToBrowserOpening(String url) {
        commandriver.navigateToUrl(url);
    }

    private void getDriverInstance() {
        driver = commandriver.getDriver();
    }

   @BeforeMethod
    public void setUp() {
        // Login To Appliaction

        clickOnTheLoginlink();
        switchToActiveWindow();
        sendInputToLoginPage();
        String welcomeMessage = waitForWelcomeMessage();
        // System.out.println(welcomeMessage);
        Assert.assertEquals(welcomeMessage, "Welcome vaibhav1");
        
    }

    private String waitForWelcomeMessage() {
        return loginPage.waitForWelcomeMessage();
    }

    private void switchToActiveWindow() {
        new SwitchToActiveElementControl(driver);
    }

    private void sendInputToLoginPage() {
        loginPage.signIn("vaibhav1", "vaibhav@123");
    }

    private void clickOnTheLoginlink() {
        loginPage.navigateToLoginUrl();
    }

    private void openBrowser(String browserName) {
        String browser = browserName.trim();
        commandriver = new CommanDriver(browser);
    }
    
    // public void selectPhone(){
    //     try {
    //         SelectPhone selectPhone = new SelectPhone(driver);
    //         selectPhone.selectSamsungGalaxtS6();

    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    // }    

    @AfterMethod
    public void cleanUp() {
        // Logout from Application
        try {
           logoutFromApplication();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void logoutFromApplication() {
        logoutPage.signOut();
    }

    @AfterClass
    public void postCleanUp() {
        try {
            driver.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
