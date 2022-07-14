// public class TwoSum {
//     // int[] input = {3,2,4};
//     public static int[] solution(int[] input, int target) {
//         int i, j;
//         for (i = 0, j = i + 1; i < input.length - 1 || j < input.length;) {
//             if (j < input.length) {

//                 if (input[i] + input[j] == target) {
//                     return new int[] { i, j };
//                 }
//                 j++;
//             } else {
//                 i++;
//                 j = i + 1;
//             }

//         }

//         return new int[] {};
//     }

//     public static void main(String[] args) {
//         int[] input = { 3, 2, 5 };
//         int target = 6;
//         int[] index = solution(input, target);
//         if (index.length > 0) {
//             for (int i : index) {
//                 System.out.println(i);
//             }
//         } else {
//             System.out.println("Not two sum present");
//         }

//     }
// }

/**
 * InnerTwoSum
 */
public class TwoSum {
    public static int[] solution(int[] input, int target) {

        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] + input[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] input = { 3, 2, 5 };
        int target = 6;
        int[] index = solution(input, target);
        if (index.length > 0) {
            for (int i : index) {
                System.out.println(i);
            }
        } else {
            System.out.println("Not two sum present");
        }

    }
}
