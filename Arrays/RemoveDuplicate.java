package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicate {
    public static void main(String[] args) {

        int[] a = { 10, 20, 10, 20, 40, 10, 30, 10 };

         ArrayList<Integer> uniqeValue = new ArrayList<Integer>();
       for (Integer i : a) {
        if(!uniqeValue.contains(i)){
            uniqeValue.add(i);
        }
       }

        int[] newArray = removeDuplicate(a);

        ArrayList<Integer>  filterArray = addArrayList(newArray);
        
       printList(filterArray);
       testFilterMethod();
       removeDuplicateUsingLinkedHashSet(a);
       
      
    }
    static void testFilterMethod(){
        int[] b = { 10, 20, 10, 20, 40, 10, 30, 10 };
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (Integer integer : b) {
          
            if(!list1.contains(integer)){
                list1.add(integer);
            }
            
        }
        System.out.println("From test filter method-->"+list1);
        
    }
    static ArrayList<Integer> addArrayList(int [] arr){
        ArrayList<Integer> filterArray = new ArrayList<Integer>();
        for (int i : arr) {
            if (i>0) {
                filterArray.add(i);
            }
        }
        return filterArray;
    }
    static void printList(ArrayList<Integer> filterArray){
        for(int value : filterArray){
            System.out.print(" "+value);
        }
    }

    static int[] removeDuplicate(int[] arr) {

        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = 0;
                }
            }
        }
        return arr;
    }

    public static void removeDuplicateUsingLinkedHashSet(int[] arr){
        ArrayList<Integer> duplicateValue = new ArrayList<Integer>(Arrays.asList(1,2,1,3,5,4,5,6,1,9,2,4,5,9));

        HashSet<Integer> list = new HashSet<Integer>(duplicateValue);
        ArrayList<Integer> uniqeValue = new ArrayList<Integer>(list);

        System.out.println("From remove Duplicate values"+uniqeValue);


        // Using Java 8 stram class
            List<Integer> newValue =  duplicateValue.stream().distinct().collect(Collectors.toList());    
            System.out.println("From Java 8 stream class"+newValue);  
        
    }
}
