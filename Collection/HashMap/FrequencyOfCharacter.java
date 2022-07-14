
package Collection.HashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FrequencyOfCharacter {
    public static void main(String[] args) {
        String s1 = "MYSPACECLASS";

        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for (int i=0; i<s1.length();i++) {
            if(!hm.containsKey(s1.charAt(i))){
                hm.put(s1.charAt(i), 1);
            }
            else{
                int count = hm.get(s1.charAt(i));
                hm.put(s1.charAt(i),count+1);
            }
        }

        for(Map.Entry<Character,Integer> value : hm.entrySet()){
            System.out.println("Key -> "+value.getKey()+" Value--> "+value.getValue());
        }

        System.out.println("-------------------------------------------------------------");

        hm.forEach((K,V)->{
        if(V>1)
        System.out.println("Key -> "+K+" Value--> "+V);});
           
        Iterator<Character> it = hm.keySet().iterator();
        while (it.hasNext()) {
            Character key = it.next();
            int value = hm.get(key);
            System.out.println(" Key =" + key + " value =" + value);

        }

    }
    
}
