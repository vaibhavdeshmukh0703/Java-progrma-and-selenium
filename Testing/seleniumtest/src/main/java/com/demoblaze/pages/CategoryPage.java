package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoblaze.pages.commanLibs.ElementControl;

public class CategoryPage {

    WebDriver driver = null;
    ElementControl elementControl;

    @FindBy(linkText = "Phones")
    WebElement Phones;

    @FindBy(linkText = "Laptops")
    WebElement Laptops;

    @FindBy(linkText = "Monitors")
    WebElement Monitors;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
        elementControl = new ElementControl();
        PageFactory.initElements(driver, this);
    }

    public void selectCategory(String category) throws Exception{
        String newCategory = category.toLowerCase().trim();
        switch (newCategory) {
            case "phones":
                elementControl.clickElement(Phones);                    
                break;
            
            case "Laptops":
                elementControl.clickElement(Laptops);                    
                break;

            case "Monitors":
                elementControl.clickElement(Monitors);                    
                break;
                
            default:
                throw new Exception("Invalid Category");
        }
    }
}
