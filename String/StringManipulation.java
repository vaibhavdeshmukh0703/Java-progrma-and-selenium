package String;
import java.util.*;

public class StringManipulation {
    public static void main(String[] args) {

        String word = "vaibhav";
        String[] splitword = word.split("");

        for (int i = splitword.length - 1; i >= 0; i--) {
            System.out.println(splitword[i]);
        }

        // using charAt() methods
        String newString = "";
        
        for (int i = word.length()-1; i >= 0; i--) {
            // ch = word.charAt(i);
            newString = newString + word.charAt(i);
        }
        System.out.println(newString + " "+word.length());

        /// find the digit from string
        
        String data = "vaibhav123";
        String y="";
        for(int i = 0; i < data.length();i++){
            if(Character.isDigit(data.charAt(i))){
                y = y + data.charAt(i);
            }   
        }
        System.out.println("Extracted Number is "+y);

        // WAP to conert String in upperCase and vise versa

        String name = "Vaibhav Deshmukh";
        for(int  i =0;i< name.length();i++){
            if(Character.isUpperCase(name.charAt(i))){
                y = y + Character.toLowerCase(name.charAt(i));
            }
            else if( Character.isLowerCase(name.charAt(i))){
                y = y + Character.toUpperCase(name.charAt(i));
            }
            else{
                 y = y + name.charAt(i);
            }
           
        }
        System.out.println(y);
        //using String Buffer
        StringBuffer sb = new StringBuffer(word);
        System.out.println("from string buffer"+ sb.reverse());

    }
}