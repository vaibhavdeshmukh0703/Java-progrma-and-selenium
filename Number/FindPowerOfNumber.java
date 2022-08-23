public class FindPowerOfNumber {

    public static int findNthPowerOfNumber(int number, int power) {
        int result = 0;
        for (int iteration = 1; iteration <= number; iteration++) {
            result = result + findPower(iteration, power);
        }
        return result;
    }

    public static int findPower(int n, int p) {
        int result = 1;
        for (int i = 1; i <= p; i++) {
            result = result * n;
        }
        return result;
    }

    // 1^5 + 2^5 + 3^5 + 4^5
    public static int recursiveApprochFindNthPower(int number, int power) {// 4 5
        int result = 0;
        if (number == 1)
            return 1;
        result = result + findPower(number, power);
        return result + recursiveApprochFindNthPower(number - 1, power);
    }

    public static void main(String[] args) {
        System.out.println(findNthPowerOfNumber(4, 2));

        System.out.println(recursiveApprochFindNthPower(4, 2));
    }
}
