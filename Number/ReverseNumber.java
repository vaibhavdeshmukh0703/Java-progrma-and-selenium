/**
 * ReverseNumber
 */
public class ReverseNumber {

    public static void main(String[] args) {
    //     int number = 010;
      
    // while(number > 0){
    //     int lastNumber = number%10;
    //     System.out.print(lastNumber);
    //     number = number /10;
    // } 
    reverseNumber(010);
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