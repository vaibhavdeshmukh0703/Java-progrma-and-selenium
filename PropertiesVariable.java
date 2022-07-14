import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertiesVariable {
   public static Properties P = null;
   public static WebDriver webdriver = null;
    static {
         P = new Properties();
        try {
            String url = "./confige.properties";
            FileInputStream fs = new FileInputStream(url);
            P.load(fs);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    
//  public static void initailSetup(String browser){
//      System.out.println(browser);
    
//     //   switch (browser) {
        
//     //     case "chrome":
//     //                 try{
//     //                     System.setProperties("webdriver.chrome.driver","/home/vaibhav/chrome_driver/chromedriver_linux64/chromedriver");
//     //                         driver = new ChromeDriver();
//     //                 }catch(Exception e){
//     //                     System.out.println(e.getMessage());
//     //                 }
//     //           break;
//     //      case "firefox":
//     //           System.out.println("Start Fire fox browser");
//     //           break;  
//     //      case "edge":
//     //           System.out.println("Start edge browser");
//     //           break;
      
//     //       default:
//     //       System.out.println("start safari browser");
//     //           break;
//     //   }
//   }

    public static void main(String[] args) 
    {
      // initailSetup(P.getProperty("browser"));
        System.out.println("from main method"+P.getProperty("browser"));
    }
}
