package String;

/**
 * SpliteString How to split a string into a number of substrings ?
 */
public class SpliteString {

    public static void main(String[] args) {
        String s1 = "vaibhav Dilip Deshmukh";
        String[] word = s1.split("\\s");
        for (String string : word) {
            System.out.println(string);
        }
       
    }
}