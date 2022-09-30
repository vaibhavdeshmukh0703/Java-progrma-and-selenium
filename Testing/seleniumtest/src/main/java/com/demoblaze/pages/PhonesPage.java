package com.demoblaze.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.pages.commanLibs.ElementControl;
import com.demoblaze.pages.commanLibs.WaitControl;

public class PhonesPage {
    WebDriver driver;
    ElementControl elementControl = null;

    @FindAll({
            @FindBy(partialLinkText = "Samsung galaxy s6"),

            @FindBy(xpath = "//a[text()='Nokia lumia 1520']"),

            @FindBy(partialLinkText = "Nexus 6"),

            @FindBy(partialLinkText = "Samsung galaxy s7"),

            @FindBy(partialLinkText = "Iphone 6 32gb"),

            @FindBy(partialLinkText = "Sony xperia z5"),
    })
    public List<WebElement> allElementFromPage;

    @FindBy(linkText = "Phones")
    WebElement PhonesCategory;

    WaitControl waitControl;

    public PhonesPage(WebDriver driver) {
        this.driver = driver;
        elementControl = new ElementControl();
        waitControl = new WaitControl(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectFromPhoneCategory() {
        elementControl.clickElement(PhonesCategory);
    }

    public void waitForElementLoad(String phone) {
        for (WebElement element : allElementFromPage) {
            if (element.getText().toLowerCase() == phone.trim().toLowerCase()) {
                waitControl.waitForElementLoad(element);
                break;
            }
        }

    }

    public void selectPhone(String nameOfPhone){
       
        String name = nameOfPhone.trim().toLowerCase();
        // System.out.println(name+ " "+allElementFromPage.size());
        for (WebElement element : allElementFromPage) {
            // System.out.println(element.getText());
            String elementString = element.getText().toLowerCase();
            System.out.println(name + "  " + elementString);
            if (elementString.equals(name)) {
                System.out.println("element found");
                elementControl.clickElement(element);
            } else {
                System.out.println("element not found");
            }
        }
    }

}
