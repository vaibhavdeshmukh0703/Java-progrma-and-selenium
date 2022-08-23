package com.example.ScreenShot;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "facebookLogin")
    public Object[][] facebookLogin(){

        return new Object[][]{
            {"https://www.facebook.com","vaibhavdeshmukh0703@gmail.com","vaibhav"}
        };
    }

    @DataProvider(name = "googleSearchData")
    public Object[] googleSearchData(){
        return new Object[]{ "https://www.google.com"};
    }


}
