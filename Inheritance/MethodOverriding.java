/**
 * MethodOverriding
 */
public class MethodOverriding {

    MethodOverriding(){

    }
    void print(){
        System.out.println("From Method Overrriding");
    }
    public static void main(String[] args) {
        MethodOverriding mo = new MethodOverriding();
        mo.print();
    }
}

class SubClass extends MethodOverriding{
    void print(){
        System.out.println("From Test Class PrintMethod");
    }

    public static void main(String[] args) {
        SubClass t = new SubClass();
        t.print();

        MethodOverriding mo = new MethodOverriding();
        mo.print();

        MethodOverriding mo1 = new SubClass();
        mo1.print();
    }
}


