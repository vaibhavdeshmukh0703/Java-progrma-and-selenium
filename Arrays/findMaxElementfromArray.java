package Arrays;

import java.util.Arrays;

public class findMaxElementfromArray {
    public static void main(String[] args) {

        // find the maximum element from the given array.
        int[] element = { 1, 2, 3, 9, 5, 6, 7, 8 };
        int sizeOfArray = element.length;
        int max = element[0],k=0;
        
        for (int i = 0; i < sizeOfArray; i++) 
        {
            if (element[i] > max) {
                max = element[i];
               
            }
        }
        System.out.println("max elememt is "  +max);
        

        // find second last element from the given array
        System.out.println("--------------------");

        Arrays.sort(element);

        System.out.println("from Array.sort method" + element[(sizeOfArray - 2)]);

        System.out.println("------------------------------------------");

        for (int i = 0; i < sizeOfArray; i++) {
            for (int j = i; j < sizeOfArray; j++) {
                if (element[i] > element[j]) {
                    int temp = element[i];
                    element[i] = element[j];
                    element[j] = temp;
                }
            }
        }
        System.out.println("from bubble sort method" + element[sizeOfArray - 2]);

    }
}
