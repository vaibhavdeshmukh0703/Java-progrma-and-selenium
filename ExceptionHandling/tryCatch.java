package ExceptionHandling;

/**
 * tryCatch
 */
public class tryCatch {

    public static void main(String[] args) {
       System.out.println(add(1, 0));
    }

    public static int add(int a, int b) throws ArithmeticException{
        int c=0;
        try {
             c =  a/b;
             System.out.println("after divided by 0");
             return c;
            
        } catch (Exception e) {
            //TODO: handle exception
           System.out.println("Arithmatic Exception");
            return c;
        }
        
    }
}