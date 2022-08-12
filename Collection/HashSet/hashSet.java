import java.util.HashSet;
import java.util.Set;

public class hashSet {
   public static void main(String[] args) {
   
    Set < Integer > set = new HashSet < > ();
    set.add(5);
    set.add(3);
    set.add(12);
    set.add(8);
    System.out.println("set: " + set);

    System.out.println("set size: " + set.size());

    set.remove(8);
    System.out.println("set size after remove: " + set.size());
    for (Integer integer : set) {
        System.out.println(integer);
    }
  }
   
}
