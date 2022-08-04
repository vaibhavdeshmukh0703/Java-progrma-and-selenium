package com.example;

import com.BeforeClass;
import com.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleTest {
 

        private WebDriver driver;
        
        @BeforeClass
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        
        @Test
        public void Seleniumtest1() {
            System.out.println("In test 1");
            driver.get("http://google.com");
            String expectedPageTitle = "Google";
           // Assert.assertTrue(driver.getTitle().contains(expectedPageTitle), "Test Failed");
        }
        
        @Test
        public void Seleniumtest2() {
            System.out.println("In test 2");
        }
        
        @Test
        public void Seleniumtest3() {
            System.out.println("In test 3");
        }
    
       // @AfterClass
        public void tearDown() {
            if(driver!=null)
                driver.quit();
        }
    }

