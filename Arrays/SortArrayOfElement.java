package Arrays;
import java.util.Arrays;

public class SortArrayOfElement {
    public static void main(String[] args) {
        int tempVar, num;
        String numbersString;
        int[] numbers = { 4, 11, 13, 12, 17, 35, 15, 7, 19, 3, 45 };

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {

                // for assending order use a>b and for Decending order use a < b;
                if (numbers[i] > numbers[j]) {
                    tempVar = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tempVar;
                }
            }
        }

        numbersString = Arrays.toString(numbers);

        System.out.println(numbersString);

        int intArr[] = { 10, 20, 15, 22, 35 };

        // To sort the array using normal sort-
        Arrays.sort(intArr);

        System.out.println("Integer Array: "
                + Arrays.toString(intArr));
    }
}
