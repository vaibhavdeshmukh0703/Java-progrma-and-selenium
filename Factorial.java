public class Factorial {
    static int fact = 1;
      static  int num = 5;
   public static void main(String[] args) {
       
       for(int i=num; i>=1;i--){
       fact = fact * i;
       
       System.out.println(fact);
   } 
}
}
