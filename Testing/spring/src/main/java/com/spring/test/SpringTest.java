package com.spring.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpringTest {
	static WebDriver driver;
	static WebDriverWait wait;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		preSetUp();
		loginToApplication();
		// for product adddition
		addProductIntoCart("Phones","Samsung galaxy s6");
		addProductIntoCart("Laptops","Dell i7 8gb");
		addProductIntoCart("Monitors","ASUS Full HD");
		// Cart Operation
		cartOperation();		
		// Place Order
		placeOrder();
		getOrderDetails();
		closeDriver();
		
	}

	

	private static void closeDriver() {
		// TODO Auto-generated method stub
		try {
			//driver.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}



	private static void getOrderDetails() {
		try {
			driver.switchTo().activeElement();
			String orderDetails = driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
			System.out.println("--------------------Order ID and Amount---------------------------");
	
			int indexOFD = orderDetails.indexOf("C");
			String finalValue = orderDetails.substring(0, indexOFD);
			
			System.out.println(finalValue);
			
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private static void placeOrder() {
		try {
			driver.findElement(By.xpath("//button[text()='Place Order']")).click();
			driver.switchTo().activeElement();
			
			driver.findElement(By.id("name")).sendKeys("Vaibhav");
			driver.findElement(By.id("country")).sendKeys("India");
			driver.findElement(By.id("city")).sendKeys("Mumbai");
			driver.findElement(By.id("card")).sendKeys("123456");
			driver.findElement(By.id("month")).sendKeys("Sep");
			driver.findElement(By.id("year")).sendKeys("2022");
			
			driver.findElement(By.xpath("//button[text()='Purchase']")).click();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private static void cartOperation() {
		// TODO Auto-generated method stub
		try {
			driver.findElement(By.linkText("Cart")).click();
			Thread.sleep(1000);
			
			List<WebElement> rowData = driver.findElements(By.xpath("//table//tbody//tr"));
			int rows = rowData.size();
			
			List<WebElement> columnData = driver.findElements(By.xpath("//table//thead//th"));
			int columns = columnData.size();
			Thread.sleep(2000);

			int productCost=0;
			System.out.println("---------------------Order Items From Cart------------------------");

			String productName="";
			int price=0;
			List<Product> product = new ArrayList<Product>();
			for(int row=1; row<=rows; row++) {
				for(int column = 2;column<=columns-1;column++) {
					String value = driver.findElement(By.xpath("//table//tbody//tr["+row+"]//td["+column+"]")).getText();
					if(column == 2){
						 productName = value;
					}
					
					 price = Integer.parseInt(value);
					//System.out.print(value+"  ");
					if(column == 3) {
						productCost = productCost + Integer.parseInt(value);
					}
				}
				product.add(new Product(productName, price));
				System.out.println();
			}
			System.out.println();

			for (Product data : product) {
				data.toString();
			}

		// Collections.sort(product);
		// for(Product name : product){
		// 	name.toString();
		// }
		// Collections.reverse(product);
		// for(Product name : product){
		// 	name.toString();
		// }

		int systemGenratedValue = Integer.parseInt(driver.findElement(By.id("totalp")).getText());
		if(systemGenratedValue == productCost) {
			System.out.println("Total value is equal to summed value -->"+  productCost+"=="+systemGenratedValue);
		}
		else {
			System.out.println("Not Equal ");
		}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	private static void addProductIntoCart(String category, String item) {
		try {
			driver.navigate().refresh();
			driver.findElement(By.xpath("//a[text()='Home ']")).click();
			driver.findElement(By.linkText(category)).click();
			
			// select Product From list
			driver.findElement(By.linkText(item)).click();
			driver.findElement(By.linkText("Add to cart")).click();
			
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	private static void loginToApplication() {
	try {
		driver.findElement(By.linkText("Log in")).click();
		driver.switchTo().activeElement();
		
		driver.findElement(By.id("loginusername")).sendKeys("sctqaautomation@grr.la");
		driver.findElement(By.id("loginpassword")).sendKeys("Spring@123");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}

	private static void preSetUp() {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://demoblaze.com/index.html");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
		    wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
