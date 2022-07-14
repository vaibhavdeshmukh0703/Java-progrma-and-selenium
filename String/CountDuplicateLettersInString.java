package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountDuplicateLettersInString {
    public static void main(String[] args) {
        // String name = "vaibhav"; Output : v=2, a=2, i=1, b=1, h=1
        String name = "vaibhav";

        // Using HashMap--> Key value pair...
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < name.length(); i++) {
            if (!hm.containsKey(name.charAt(i))) {
                hm.put(name.charAt(i), 1);
            } else {
                int count = hm.get(name.charAt(i));
                hm.put(name.charAt(i), count + 1);
                // hm.computeIfPresent(name.charAt(i),(k,v) -> v+1);

            }
        }

        Set<Character> keys = hm.keySet();
        for (Character key : keys) {
            if(hm.get(key)!=0){
                System.out.println(hm.get(key));
            }
            else{
            System.out.println("true");
            }
        
        }
        // hm.forEach((k, v) -> {
        //     System.out.println("key--> " + k + " Value-->" + v);
        // });

        // --------------------------Using another Method----------------------
        // String name = "vaibhav"; Output : v=2, a=2, i=1, b=1, h=1
       
    }

}
