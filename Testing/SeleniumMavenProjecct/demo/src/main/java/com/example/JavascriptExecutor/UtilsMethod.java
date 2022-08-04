package com.example.JavascriptExecutor;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilsMethod {
    public static String getPageTilte(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String Script = "return document.title";
        String Title = js.executeScript(Script).toString();
        return Title;

    }

    public static void drawBorder(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String Script = "arguments[0].style.border='3px solid red'";
        js.executeScript(Script, element);

    }

    public static void takeScreenShot(WebDriver driver, WebElement element, String targetFileName) {
        try {
            File src = null;
            if (element == null) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                src = ts.getScreenshotAs(OutputType.FILE);
            } else {
                src = element.getScreenshotAs(OutputType.FILE);
            }
            File target = new File("./Testing/SeleniumMavenProjecct/demo/src/main/java/com/example/Images/"
                    + targetFileName + ".jpg");
            FileUtils.copyFile(src, target);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void generateAlert(WebDriver driver, String message) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String Script = "alert('" + message + "')";
            js.executeScript(Script);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void refereshPage(WebDriver  driver){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String Script = "history.go(0)";
            js.executeScript(Script);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void scrollDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String Script = "window.scrollBy(0,document.body.scrollHeight )";
        js.executeScript(Script);
    }

    public static void scrollUp(WebDriver driver){
        try {
            JavascriptExecutor js= (JavascriptExecutor) driver;
            String Script = "window.scrollBy(0,-document.body.scrollHeight )";
            js.executeScript(Script);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void ZoomPage(WebDriver driver,int percentage){
        try {
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("document.body.style.zoom='"+percentage+"%'"); 
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }

    public static void flash(WebDriver driver,WebElement element){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String color = element.getCssValue("background-color");
            for(int i=0;i<10;i++){
                changeColor("#000001",driver,element);
                changeColor(color, driver, element);
            }

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    public static void changeColor(String color, WebDriver driver, WebElement element){
        try {
            JavascriptExecutor js =  (JavascriptExecutor) driver;
            String Script = "arguments[0].style.background-color='"+color+"'";
            js.executeScript(Script,element);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
