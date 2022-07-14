package String;

public class ConverInUpperCase {
   public static void main(String[] args) {
       String str1 = "vaibhav";
       String y="";
      // System.out.println(str1.toUpperCase());

       for(int i=0;i<str1.length();i++)
       {
           if(i % 2 == 0){
              y = y + Character.toUpperCase(str1.charAt(i));
           }
           else{
            y = y + str1.charAt(i);
           }
           ;
           
       }
       System.out.println(y);
   } 
}
