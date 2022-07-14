//1) this: to refer current class instance variable
public class ThisKeyword {
    int rollno;
    String name;
    float fee;

    ThisKeyword(int rollno, String name, float fee) {
        this.rollno = rollno;
        this.name = name;
        this.fee = fee;
    }

    void display() {
        System.out.println(rollno + " " + name + " " + fee);
    }
}

class TestThis1 {
    public static void main(String args[]) {
        ThisKeyword s1 = new ThisKeyword(111, "ankit", 5000f);
        ThisKeyword s2 = new ThisKeyword(112, "sumit", 6000f);
        s1.display();
        s2.display();
    }
}

// 2) this: to invoke current class method
class A {
    void m() {
        System.out.println("hello m");
    }

    void n() {
        System.out.println("hello n");
        // m();//same as this.m()
        m();
    }
}

class TestThis4 {
    public static void main(String args[]) {
        A a = new A();
        a.n();
    }
}

// 3) this() : to invoke current class constructor

class B {
    B() {

        System.out.println("hello a");

    }

    B(int x) {
        this();
        System.out.println(x);
    }
}

class TestThis5 {
    public static void main(String args[]) {
        B a = new B(10);
    }
    }

class A5 {
    void m() {
        System.out.println(this);// prints same reference ID
    }

    public static void main(String args[]) {
        A5 obj = new A5();
        System.out.println(obj);// prints the reference ID
        obj.m();
    }
}