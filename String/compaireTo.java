package String;

public class compaireTo {
    public static void main(String[] args) {
        String s1 = "vaibhav";
        String s2 = "vaibhav";
        String s3 = "VAIBHAV";
        Object s4 = s3;
        System.out.println(s3.compareTo(s4.toString()));
        System.out.println(s1.compareTo(s2));
        System.out.println(s1.compareTo(s3));
    }
    
}
