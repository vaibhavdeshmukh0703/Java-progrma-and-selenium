package String;

public class SearchWordInString {
    public static void main(String[] args) {
        String s1 = "Vaibhav Dilip Deshmukh";
        System.out.println(s1.indexOf("Deshmukh"));

        String s2 = "Welcome to microsoft";
        String s3 = "I work With Microsoft";
        String [] s2Word = s2.split("\\s");
        String [] s3word = s3.split("\\s"); 
        for(String s:s3word){
        System.out.print(s);
        }




      
     
    }
    
}
