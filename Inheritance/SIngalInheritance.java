package Inheritance;

/**
 * InnerSIngalInheritance
 */
class parent {
    public void car() {
        System.out.println("This method belongs to parent---car");
    }

    public void bunglow() {
        System.out.print("this method belongs to Parent---bunglow");
    }

}



public class SIngalInheritance extends parent {

    public void bike(){
        System.out.println("child bikeclsaa");
        super.bunglow();
        System.out.println("this methodbelongs to child --- bike");
    }
    public void bunglow() {
        System.out.print("this method belongs to child---bunglow");
    }

    public static void main(String[] args) {
        // parent p= new parent();
        // p.bunglow();

        parent p1 = new SIngalInheritance();
        p1.car();//// oNLy parent class methods ar accesible
        p1.bunglow();
        

        // SIngalInheritance s = new SIngalInheritance();
        // s.bike();
        // s.car();
        
    }
}
class check{
     check()
    {

    }
    public static void main(String[] args) {
    
     check.test();   
    }
    public static void test(){
        System.out.println("from same class");
    }
}