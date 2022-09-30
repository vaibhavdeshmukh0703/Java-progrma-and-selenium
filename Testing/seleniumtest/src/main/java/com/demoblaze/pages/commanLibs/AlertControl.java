package com.demoblaze.pages.commanLibs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertControl {

    Alert alert = null;
    public AlertControl(WebDriver driver) {
        alert = driver.switchTo().alert();
    }

    public void acceptAlert() {
        alert.accept();
    }

    public void dismissAlert() {
        alert.dismiss();
    }

    public String getText() {
      return alert.getText();
    }

    public void sendText(String input) {
        alert.sendKeys(input);
    }
}
