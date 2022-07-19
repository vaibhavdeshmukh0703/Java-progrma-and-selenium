public class StaticKeyword {
    StaticKeyword(){
        
    }
     String by;
    static{
        System.out.println("from static block");
    }

    
    public static void abc(String[] args){
        System.out.println("from intger main method");
    }
   public static void main(String[] args) {
   
        System.out.println("default value of local variable");
        
        System.out.println("from main method");
        String fname = "Vaibhav";
        String fname3 = "Vaibhav";
       
       
    String fname1 = new String("Vaibhav"); // true
    String fname2 = new String("Vaibhav");
    System.out.println(fname.equals(fname3)); //true
    System.out.println(fname == fname3); //true
    System.out.println(fname == fname1);//false
    System.out.println(fname1==fname2); // false
    System.out.println(fname.equals(fname2));//true  

    System.out.println("vaibhav"+ 10*20);
    System.out.println(10*20+"vaibhav");
    for(int i=0;0;i++){
        System.out.println("vaibhav");
    }
   }  
   
}
