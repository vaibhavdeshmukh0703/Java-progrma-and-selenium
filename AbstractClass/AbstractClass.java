import com.AbstractClass.AbstractClass;

/**
 * AbstractClass
 */
public abstract class AbstractClass {
     static int a = 10;

    AbstractClass() {
        System.out.println("from constructor");
    }

    abstract public void run();

    public final void Test() {
        System.out.println("From test");
    }
    public static void test1(){
        System.out.println("from static method test1");
    }
}

/**
 * InnerAbstractClass
 */
class InnerAbstractClass extends AbstractClass {
    public void run() {
        System.out.println("overrided run from abstractclass"+AbstractClass.a++);
    }
    
    // public void Test(){
    //     System.out.println("From Overided Test method");
    // }
}

class AbstractClassFactory {
    public AbstractClass getFactory() {
        return new InnerAbstractClass();
    }
}

class Access {
    public static void main(String[] args) {
        AbstractClassFactory acb = new AbstractClassFactory();
        AbstractClass ac = acb.getFactory();
        ac.Test();
        ac.test1();
        ac.run();
        System.out.println(ac.a);
    }
}
