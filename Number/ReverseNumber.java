/**
 * ReverseNumber
 */
public class ReverseNumber {
    public static void main(String[] args) {
        reverseNumber(12345);
    }

    public static void reverseNumber(int number) {
        if (number < 10) {
            System.out.println(number);
        } else {
            System.out.print(number % 10);
            number = number / 10;
            reverseNumber(number);
        }
    }

}