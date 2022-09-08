package com.example.ActionClass;
import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardAction {
   public static void main(String[] args) {
    System.out.println(System.getProperty("user.dir"));
    System.out.println(Paths.get(System.getProperty("user.dir")).getFileName());
    initialSetUp();
   }

private static void initialSetUp() {
    try {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://text-compare.com/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println("web page title is " + title);
        keyBoardActionsMethod(driver);

    } catch (Exception e) {
        //TODO: handle exception
        System.out.println(e.getMessage());
    }

}

private static void keyBoardActionsMethod(WebDriver driver) {
    try {
        // Web Element for TextArea
        WebElement TextArea1 = driver.findElement(By.id("inputText1"));
        WebElement TextArea2 = driver.findElement(By.id("inputText2"));
        TextArea1.sendKeys("Selemium Is good");
       
        // Actions class instance create
        Actions actions = new Actions(driver);

        // Key Board Action implimentation
        //Ctrl + A
        Action selectText = actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();
        selectText.perform();
       
        // Ctrl + C
       Action copyText =  actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build();
       copyText.perform();

       // press Fn+F1
    //    Action pageDown = actions.sendKeys(Keys.PAGE_DOWN).build();
    //    pageDown.perform();

       // Press Tab Key
       actions.sendKeys(Keys.TAB).perform();

       //Ctrl + V
       Action pestText = actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build();
       pestText.perform();

       //Compaire tezt from 2 TxtBoxes

       if(TextArea1.getAttribute("value").equals(TextArea2.getAttribute("value"))){
        System.out.println("Text copied from Succesfully");
       }else{
        System.out.println("Text Not Copied");
       }

     //  Keys.chord(null)

       // Take screenshot of page
        File source = TextArea1.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+"/Testing/SeleniumMavenProjecct/demo/src/main/java/com/example/Images/screenShot.jpeg");
        FileUtils.copyFile(source, target);

       System.out.println(TextArea1.getAttribute("placeholder"));
       System.out.println(TextArea1.getText());
       System.out.println(TextArea1.getCssValue("Color"));
       System.out.println(TextArea1.getTagName());
       System.out.println(TextArea1.getClass());
       System.out.println(TextArea1.getLocation());
       System.out.println(TextArea1.getRect());
       System.out.println(TextArea1.getSize());

        } catch (Exception e) {
        //TODO: handle exception
        System.out.println(e.getMessage());
    }
} 
}
