import java.util.ArrayList;
import java.util.List;

/**
 * ReverseNumber
 */
public class ReverseNumber {
    
    public static int x=10;
    public static void main(String[] args) {
    //     int number = 010;
      
    // while(number > 0){
    //     int lastNumber = number%10;
    //     System.out.print(lastNumber);
    //     number = number /10;
    // } 
   reverseNumber(12345);
   
    }
    
 
 public static void reverseNumber(int number){
     if(number<10){
         System.out.println(number);
     }else{
         System.out.print(number%10);
         number =number/10;
         reverseNumber(number);
     }
 }
 
}