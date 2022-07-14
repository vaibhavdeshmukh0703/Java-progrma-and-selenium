public class Fibonacci {
    // print fibonacci of 7
    // 0 1 1 2 3 5 8 13
    public static void main(String[] args) {
        int[] fiboseries = fibo(7);
        for (int element : fiboseries) {
            System.out.print(" " + element);
        }
        
    }

    static int[] fibo(int num) {

        int f[] = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            if (i == 0)
                f[i] = 0;
            else if (i == 1)
                f[i] = 1;
            else
                f[i] = f[i - 1] + f[i - 2];

        }
        return f;
    }

    public static String print() {
        System.out.println("from static method print");
        String S = "return type";
        System.out.println(S.length());
        System.out.println(S.charAt(5));
        System.out.println(S.contains("type"));
        System.out.println(Character.toUpperCase('r'));
        System.out.println(Character.getNumericValue('r'));
        System.out.println(S.indexOf(S.charAt(5)));
        // System.out.println(Char[] = S.toCharArray());
        String newString = "";
        char ch;
        for (int i = 0; i < S.length(); i++) {
            ch = S.charAt(i);

            newString = ch + newString;

        }
        System.out.println(newString);

        return S;
    }

}

class Test {
    public static void main(String[] args) {
        String returnValue = Fibonacci.print();
        System.out.println(returnValue);
    }
}