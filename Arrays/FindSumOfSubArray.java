package Arrays;

/**
 * input:
 * arr[] = {1,5,10,20,80}
 * target = 90
 * 
 * output:
 * 1
 * 
 * input:
 * arr[] = {1,5,10,20,80}
 * target = 40
 * 
 * output:
 * 0
 * 
 */

public class FindSumOfSubArray {
    public static void main(String[] args) {
        int[] array = {1,5,10,20,80};
        int target = 6;
        boolean result = findsumofubarray(array, target);
        System.out.println(result);
    }

    public static boolean findsumofubarray(int[] array, int targetValue) {
        int startingIndex = 0, endingIndex = array.length - 1;

        while (startingIndex <  endingIndex ) {
            int sum = array[startingIndex] + array[endingIndex];
            //System.out.println(sum);+
            if (sum == targetValue) {
                return true;
            } else if (sum < targetValue) {
                
                startingIndex++;
            } else {
                endingIndex--;
            }
        }
        return false;
    }
}
