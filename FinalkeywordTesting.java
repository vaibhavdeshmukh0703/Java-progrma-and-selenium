class FinalkeywordTesting {

    final void print(String name) {
        System.out.println("from class A My name is" + name);
    }

}

class B extends FinalkeywordTesting {
    public void printname() {
        System.out.println("fron class  B My name is vaibhav");

    }
    /*
     * cannot override thie final method from FinalKeywordTesting
     * public void print(String name) {
     * System.out.println("fron class  B My name is vaibhav");
     * 
     * }
     */

}

class child {
    public static void main(String[] args) {
        // final int a= 15; a=25;
        // System.out.println(a);
        B b = new B();
        b.print("va");
        b.printname();
    }
}
