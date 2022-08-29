public class ArryIndexOutOFBoundException {
    public void m1(){
        System.out.println("from m1");
    }
    public  void m2(){
        System.out.println("from m2");
        this.m1();
    }
    public static void main(String[] args) {
     ArryIndexOutOFBoundException a = new ArryIndexOutOFBoundException();
     a.m2();
     int[] array = new int[4];
     System.out.println(array[5]);

        
    }    
}
