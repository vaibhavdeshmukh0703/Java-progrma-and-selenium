import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;



/**
 * filter
 */
public class filter {
    public static ArrayList<Integer> number = null;
    public static void filterMethod(){
         number = new ArrayList<Integer>(Arrays.asList(10,15,20,25,8,3,35,40));
        ArrayList<Integer> filterNumber = number.stream().filter(eachNumber->(eachNumber%2==0)).collect(Collectors.toList());
        System.out.println("Numbre before filter"+number);
        System.out.println("numbre After Filter"+filterNumber);
    }

    public static void mapMethod(){
        List<Integer> updatedNumber = number.stream().map(number -> (number + 5)).collect(Collectors.toList());
       
        System.out.println("Numbre before filter"+number);
        System.out.println("numbre After Updated"+updatedNumber);
    }
    public static void sorting(){
        List<Integer> sortedArray = number.stream().sorted().collect(Collectors.toList());
         List<Integer> descendingOrderNumbre = number.stream().sorted((a,b)->b.compareTo(a)).collect(Collectors.toList());
         List<Integer> compare = number.stream().sorted((a,b)->(a<b?1:a>b?-1:0)).collect(Collectors.toList());

        System.out.println("Sorted Array is"+sortedArray);
        System.out.println("Desending Order Array is"+descendingOrderNumbre);
        System.out.println("Using Comaparator"+compare);
    }
    public static void stringSorted(){
        ArrayList<String> name = new ArrayList<String>(Arrays.asList("vaibahv","shekhar","vijay","akshay"));
        List<String> sortedName = name.stream().sorted().collect(Collectors.toList());
        List<String> descOrderName = name.stream().sorted((a,b)->(b.compareTo(a))).collect(Collectors.toList());
       
        // List<String> onBasisOfLength = name.stream().sorted((name1,name2)->{
        //      int name1Length = name1.length();
        //     int name2Length = name2.length();
        //     if(name1Length>name2Length) return 1;
        //     else if(name1Length<name2Length) return -1;
        //     else return name1.compareTo.name2;
        // }).collect(Collectors.toList());

        System.out.println(sortedName);
        System.out.println(descOrderName);
        //System.out.println(onBasisOfLength);
    }
    public static void count(){
        long count = number.stream().filter(number->number>20).count();
        System.out.println("No Of Count is "+count);
        
    }
    public static void minMax(){
        Integer min = number.stream().min((a,b)->a.compareTo(b)).get();
        System.out.println(min);
        Integer max = number.stream().max((a,b)->a.compareTo(b)).get();
        System.out.println(max);
    }
    public static void forEach(){
       
        number.stream().forEach((number)->{
            number = number *10;
            System.out.print(number+" ");
           
        });
        System.out.println();
    }
    public static void toArray(){
        // to convert stream of object in to array.
        Integer[] integer = number.stream().toArray(Integer[]::new);// constructor refernce Integer[]::new
       for (Integer integer2 : integer) {
           System.out.print(integer2+" "); 
           
        }
        System.out.println();
        // To convert Array type to srteam type use stream.of(integer)
        Stream.of(integer).forEach((number)->{
            System.out.print(number+" ");
        });
    }
    public static void main(String[] args) {
        filterMethod();
        mapMethod();
        sorting();
        stringSorted();
        count();
        minMax();
        forEach();
        toArray();
    }
}