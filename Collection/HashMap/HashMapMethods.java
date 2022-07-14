package Collection.HashMap;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapMethods {
    public static void main(String[] args) {
        System.out.println("hash map Program Methods");
        HashMap<String, String> capitalMap = new HashMap<String, String>();
        capitalMap.put("India", "New Delhi");
        capitalMap.put("USA", "Washington Dc");
        capitalMap.put("Uk", "London");
        capitalMap.put("Uk", "London11");
        capitalMap.put("Russia", null);
        capitalMap.put("France", null);

        capitalMap.remove("Russia");

        System.out.println(capitalMap.get("India"));
        System.out.println(capitalMap.get("USA"));

        System.out.println(capitalMap.get(null));
        System.out.println(capitalMap.get("France"));

        Iterator<String> it = capitalMap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = capitalMap.get(key);
            System.out.println(" Key =" + key + " value =" + value);
        }
        System.out.println("-----------------------------");

        capitalMap.forEach((k,v)-> System.out.println("key ="+k+"value="+v));

        System.out.println("-----------------------------");
                


    }
}
