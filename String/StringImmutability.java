public class StringImmutability {
    public static void main(String[] args) {
        String x = "abc";
        String y = "abc";
        x = x.concat(y);
        System.out.println(x + "------" + y);

    }
}
