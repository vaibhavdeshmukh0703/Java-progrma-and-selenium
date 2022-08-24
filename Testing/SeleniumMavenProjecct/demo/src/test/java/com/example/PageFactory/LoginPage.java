package com.example.PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage{
    WebDriver driver=null;
    
    @FindBy( id="email")
    WebElement facebookEmailTag;
    
    @FindBy(id="pass")
    WebElement facebookPasswordTag;

    @FindBy(id="u_0_5_MM")
    WebElement submit;

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
    LoginPage(WebDriver d){
       driver = d; 
       PageFactory.initElements(driver, this); 
    }

    public void setEmail(String email){
        facebookEmailTag.sendKeys(email);;
    }
    public void setPassword(String password) {
        facebookPasswordTag.sendKeys(password,Keys.ENTER);
    }

    public void clickSubmit(){
        submit.click();
    }

    public String getLoginTitile(){
        return driver.getTitle();
    }

    public void loginToFacebook(String EmailId, String Password){
        // fill the Email id;
        this.setEmail(EmailId);

        // Fill the Password;
        this.setPassword(Password);

        // click the submit button
        this.clickSubmit();

    }
}
    