public class FindPowerOfNumber {
    static int count = 0;
    public static int findNthPowerOfNumber(int number, int power) {
        int result = 0;
        for (int iteration = 1; iteration <= number; iteration++) {
            result = result + findPower(iteration, power);
        }
        return result;
    }

    public static int findPower(int number, int power) {
    //     int result = 1;
    //     for (int i = 1; i <= power; i++) {
    //         result = result * number;
    //    }
    //    return result;
    count++;
      if(power ==0) return 1;
        return number* findPower(number, power-1);
    }

    // 1^5 + 2^5 + 3^5 + 4^5
    public static int recursiveApprochFindNthPower(int number, int power) {// 4 5
        count++;
        int result = 0;
        if (number == 1)
            return 1;
        result = result + findPower(number, power);
        return result + recursiveApprochFindNthPower(number - 1, power);
    }

    public static void main(String[] args) {
        System.out.println(findNthPowerOfNumber(4, 2));

        System.out.println(recursiveApprochFindNthPower(4, 2));
        System.out.println(count);
    }
}
