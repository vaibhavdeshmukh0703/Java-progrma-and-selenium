public class swapStringWithoutThierdVariable {
    public static void main(String[] args) {
        String a="Hello";
        String b="Hi";      // b= Hello a=Hi
        System.out.println("before Swap a="+a+" and b= "+b);

        a=a+b;// HelloHi
        b=a.replace(("Hi"), "");
        a= a.replace("Hello", "");
        System.out.println("After swaping a="+a+" and b = "+b);
    }
}
