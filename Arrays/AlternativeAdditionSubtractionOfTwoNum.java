package Arrays;

// 2-4+6-8+10-12+14-16+18-20
public class AlternativeAdditionSubtractionOfTwoNum {
    public static void main(String[] args) {
        int sum = 0, count = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {

                count++;
                if (count % 2 == 1) {
                    sum = sum + i;
                } else {
                    sum = sum - i;
                }
            }
        }
        System.out.println(sum);
    }
}
