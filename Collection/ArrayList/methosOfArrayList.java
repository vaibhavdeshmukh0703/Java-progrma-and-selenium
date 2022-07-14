package Collection.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.xml.transform.Source;

public class methosOfArrayList {
    public static void main(String[] args) {
        ArrayList<String> ar1 = new ArrayList<String>();
        ar1.add("Java");
        ar1.add("Python");
        ar1.add("Ruby");
        ar1.add("javaScripte");

        ArrayList<String> ar3 = new ArrayList<String>();
        ar1.add("Testing");
        ar1.add("Devops");

        // Methods of ArrayList
        // ar1.addAll(ar2);

        ar1.addAll(ar3);
        System.out.println(ar1);

        // list1.addAll(index,list2) index --> where from add second arraylist

        // ar2.addAll(ar1);
        // System.out.println(ar1);
        // // ar2.clear();
        // System.out.println(ar2);

        // clone arraylist ar1.clone() return an object. we nned to type cast it convert
        // from object to arraylist

        ArrayList<String> cloneList = (ArrayList<String>) ar1.clone();
        System.out.println(cloneList);

        System.out.println(ar1.contains("Java"));
        System.out.println(ar1.contains("c"));
        System.out.println(ar1.indexOf("Ruby") > 0);

        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("Naveen", "tom", "Naveen", "vaibhav", "abc"));
        System.out.println(list1);

        int index = list1.indexOf("vaibhav");
        System.out.println(index);

        index = list1.lastIndexOf("Naveen");
        System.out.println(index);

        list1.remove(list1.indexOf("abc"));
        System.out.println(list1);

        list1.add("abc");

        list1.remove(4);
        System.out.println(list1);

        ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 3, 4, 5, 6, 7, 8, 9));

        ArrayList<Integer> uniqeValue = new ArrayList<Integer>();
        for (Integer i : numbers) {
            if (!uniqeValue.contains(i)) {
                uniqeValue.add(i);
            }
        }
        List<Integer> number = new ArrayList<Integer>(Arrays.asList(10,20,30,40,50,60));
        number.removeIf(num->num>20);
  
        System.out.print("Uniqe array is---->" + uniqeValue);

        /// filter array list using java8 stram method
        HashMap<Integer, Long> maxFilterList = new HashMap<Integer, Long>();

        Map<Integer, Long> filteredList = numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        filteredList.entrySet().stream().filter((entry) -> entry.getValue() == Collections.max(filteredList.values()))
                .forEach(entry -> maxFilterList.put(entry.getKey(), entry.getValue()));

                filteredList.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println("------------------------------------------");

        maxFilterList.forEach((k, v) -> System.out.println(k + ":" + v));

        numbers.retainAll(Collections.singleton(3));
        System.out.println("From retainAll method------>" + numbers);

        numbers.removeIf(num -> num % 2 != 0);
        System.out.println("from even number" + numbers);

        numbers.removeIf((num) -> num % 2 == 1);
        System.out.println("From even numbers---->" + numbers);

        Iterator it = numbers.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
