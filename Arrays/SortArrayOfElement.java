package Arrays;

import java.util.Arrays;

public class SortArrayOfElement {
    public static void main(String[] args) {
        int tempVar, num;
        String numbersString;
        int[] numbers = { 4, 11, 13, 12, 17, 35, 11, 7, 12, 13, 45 };

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

        int[] newArray = new int[numbers.length];
        int count = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] != (numbers[i + 1])) {

                newArray[count] = numbers[i];
                count++;
            }
        }
        for (int i : newArray) {
            System.out.print(i + " ");
        }

       // System.out.println(count);

        // int intArr[] = { 10, 20, 15, 22, 35 };

        // // To sort the array using normal sort-
        // Arrays.sort(intArr);

        // System.out.println("Integer Array: "
        //         + Arrays.toString(intArr));
    }
}
