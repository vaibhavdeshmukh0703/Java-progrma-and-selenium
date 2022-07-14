public class NumberIsPalindrom {
    public static boolean isPalindrom(int number) {
        int temp = number, reverseNumber = 0;
        if (number == 0 || number > 0) {
            while (number != 0) {
                reverseNumber = reverseNumber * 10 + number % 10;
                number = number / 10;
            }
            return temp == reverseNumber;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int number = 123;
        System.out.println(isPalindrom(number));
        System.out.println(Math.abs(123));

    }
}
