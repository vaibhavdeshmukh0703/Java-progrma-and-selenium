public class Polymorphisom {

    int a = 12;
    public static void run() {
       System.out.println("from run"); 
    }
       void run(int a){
        System.out.println("from poly"+a);
    }
    
 
}
class Derived extends Polymorphisom{
    public  void run(int a){
        super.a=20;
        super.run(a);
        System.out.println("derived run");
    }
    public static void main(String[] args) {
        Polymorphisom p = new Derived();
        p.run(1);
    }
}
