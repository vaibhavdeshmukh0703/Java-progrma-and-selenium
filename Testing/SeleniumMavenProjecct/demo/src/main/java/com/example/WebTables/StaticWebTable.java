package com.example.WebTables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * StaticWebTable
 * How many row in table
 * How many coloum in table
 * Retriew the specifice row or coloum data
 * Retriew the all data from table
 * Print company-Island Trading contact-Helen Bennett county-Uk
 * 
 */
public class StaticWebTable {
    public static void initialSetUp(){
        try {
           WebDriverManager.chromedriver().setup();
           WebDriver driver = new ChromeDriver();
           driver.get("https://www.w3schools.com/html/html_tables.asp"); 
           driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
           testCaseForWebTable(driver);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
   private static void testCaseForWebTable(WebDriver driver) {
    try {
        // find rows of table
        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
       int numberOfTableRows = tableRows.size();
        System.out.println("Row in table is-->"+numberOfTableRows);

        // find number of coloum in table
        List<WebElement> tableColoum = driver.findElements(By.xpath("//table[@id='customers']//th"));
        int NumberOfTableColoums = tableColoum.size();
        System.out.println("NUMBER OF cloum is-->"+NumberOfTableColoums);

        //Retriew Specifice data from table
       
                String data = driver.findElement(By.xpath("//table[@id='customers']//tr[4]//td[1]")).getText();
                System.out.println(data);
            
        //// retriew all table data
        String tabledata;
        for(int row =1; row<=numberOfTableRows;row++){
            for (int coloum = 1; coloum<= NumberOfTableColoums; coloum++) {
                if(row==1){
                    tabledata = driver.findElement(By.xpath("//table[@id='customers']//tr["+row+"]//th["+coloum+"]")).getText();  
                }else{
                       tabledata = driver.findElement(By.xpath("//table[@id='customers']//tr["+row+"]//td["+coloum+"]")).getText();
                }
              
               // System.out.println("----------------------------------------------------------");
                System.out.print(tabledata+"  ");
            }
            System.out.println();
        }

        
    } catch (Exception e) {
       System.out.println(e.getMessage());
    }
    }
public static void main(String[] args) {
    initialSetUp();
   } 
}