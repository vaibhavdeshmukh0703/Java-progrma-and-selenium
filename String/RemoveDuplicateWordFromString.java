package String;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RemoveDuplicateWordFromString {
    public static void main(String[] args) {
        String s1 = "Vaibhav Dilip Deshmukh Vaibhav Dilip Deshmukh satara";
      
      String [] stringWords = s1.split("\\s");
      ArrayList<String> list = new ArrayList<String>();

      for(String s : stringWords){
          if(!list.contains(s)){
              list.add(s);
          }
      }
      String New = list.toString();
      System.out.println(New);
      
     
    }
    
}
