public class FibonacciNumber {
    public static int fibonacci(int number) {
        if (number == 0)
            return 0;
        if (number == 1 || number == 2)
            return 1;
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static int additionOfPrimeNumber(int number) {
        if (number == 1)
            return 1;
        return number + additionOfPrimeNumber(number - 1);

    }

    public static void main(String[] args) {
        int number = fibonacci(6);
        System.out.println(number);

        System.out.println(additionOfPrimeNumber(5));
    }
}
