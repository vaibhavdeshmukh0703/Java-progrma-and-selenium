package com.example.PageFactory;

import java.util.concurrent.TimeUnit;

import com.example.ScreenShot.BaseClass;

import org.junit.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {

    public void getUrl(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void LoginPageTest() {
        this.getUrl("https://www.facebook.com");
        LoginPage loginPage = new LoginPage(driver);

        String webPageTitle = loginPage.getLoginTitile();
        System.out.println("web Title  ->" + webPageTitle);
        // loginPage.loginToFacebook("vaibhav","vaibhav");
        Assert.assertTrue(webPageTitle.equalsIgnoreCase("Facebook – log in or sign up"));
    }

}
