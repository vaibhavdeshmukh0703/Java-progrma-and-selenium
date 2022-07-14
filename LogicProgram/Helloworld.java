package LogicProgram;

/**
 * Helloworld
 */
public class Helloworld {

    public static void main(String[] args) {
        int[] a = {};
        String[] s = {};
        int output = add(5, 6);
        System.out.println(output);
        Helloworld hw = new Helloworld();
        hw.add("a", "b");

        innerHelloworld.main(s);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public void add(String a, String b) {
        System.out.println(a + b);
    }
}

/**
 * InnerHelloworld
 */
class innerHelloworld {

    public static void main(String[] args) {
        System.out.println("hello");
        innerHelloworld.main("edurekan");
    }

    public static void main(String arg1) {
        System.out.println(" welcome" + arg1);
        innerHelloworld iw = new innerHelloworld();
        iw.main("welcome", "to edureka");
    }

    public void main(String arg1, String arg2) {
        System.out.println("hello" + arg1 + arg2);
    }
}

class Parent {
    void view(){
    System.out.println("this is a parent class method");
    }
}

class Child extends Parent {
    void view(){
    System.out.println("this is a child class method");
    }

public static void main(String args[]){
    Parent ob = new Parent();
    ob.view();
    Parent ob1 = new Child();
    ob1.view();
    Child c =new Child();
    c.view();

}}
