import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriverCommandExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            System.setProperty("webdriver.chrome.driver", "/home/vaibhav/crome_driver/chromedriver_linux64/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.co.in");

            driver.manage().window().maximize();
            
            String Title = driver.getTitle();

            WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(10));
            ww.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("मराठी")));
            driver.findElement(By.linkText("मराठी")).click();

            // WebDriverWait www = new WebDriverWait(driver, Duration.ofSeconds(40));
            ww.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            driver.findElement(By.name("q")).sendKeys("java interview questions");;
            driver.findElement(By.className("iblpc")).submit();

           
           ww.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.edureka.co/blog/interview-questions/java-interview-questions/']")));
              driver.findElement(By.xpath("//a[@href='https://www.edureka.co/blog/interview-questions/java-interview-questions/']")).click();
            
           

            System.out.println(Title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
     
}}
