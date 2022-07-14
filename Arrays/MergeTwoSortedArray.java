package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] ar1 = { 1, 3, 5, 7, 9 };
        int[] ar2 = { 2, 4, 6, 8 };
        // int[] mergedArray = mergeArray(ar1, ar2);
        // for (int i : mergedArray) {
        //     System.out.print(i);
        // }

        ArrayList<Integer> newMergedArray = newMergeArray(ar1,ar2);
        System.out.println("From arrayList");
        for (int i : newMergedArray) {
            System.out.print(i);
        }
    }

    public static int[] mergeArray(int[] array1, int[] array2) {
        // find out length of two arrays.
        int array1Length = array1.length;
        int array2Length = array2.length;
        int[] mergedArray = new int[array1Length + array2Length];
        int i = 0, j = 0, k = 0;
        // int[] ar1 = { 1, 3, 5, 7, 9 };
        // int[] ar2 = { 2, 4, 6, 8 };
        while (i < array1Length && j < array2Length) {
            if (array1[i] < array2[j]) {

                mergedArray[k++] = array1[i++];

            } else {

                mergedArray[k++] = array2[j++];

            }

        }
        while (i < array1Length) {
            mergedArray[k++] = array1[i++];
        }
        while (i < array2Length) {
            mergedArray[k++] = array2[i++];
        }
        return mergedArray;
    }

    public static ArrayList<Integer> newMergeArray(int[] array1, int[] array2) {
        ArrayList<Integer> arrLit  = new ArrayList<Integer>();
       
        int i=0,j=0;
        while(i<array1.length && j<array2.length){
            if(array1[i] < array2[j]){
            
                arrLit.add(array1[i]);
                i++;
            }
            else{
                arrLit.add(array2[j]);
                j++;
            }
        }
        while(i<array1.length){
            arrLit.add(array1[i]);
            i++; 
        }
        while(i<array2.length){
            arrLit.add(array2[j]);
            j++; 
        }
        return arrLit;
        
    }
}
