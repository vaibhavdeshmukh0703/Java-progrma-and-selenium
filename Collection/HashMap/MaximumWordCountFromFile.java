package Collection.HashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaximumWordCountFromFile {

    static String path = "./Collection/HashMap/Data.txt";

    public static void main(String[] args) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        FileReader file = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String singleLineOfDataFromFile = br.readLine();
            while (singleLineOfDataFromFile != null) {
                String[] wordArray = singleLineOfDataFromFile.toLowerCase().trim().replace(".", "").split(" ");

                for (String word : wordArray) {
                    System.out.println(word);
                    if (!word.isBlank()) {
                        if (!hm.containsKey(word)) {
                            hm.put(word, 1);

                        } else {
                            // hm.computeIfPresent(word,(k,v)-> v+1);
                            hm.put(word, hm.get(word) + 1);
                        }
                    }
                }
                singleLineOfDataFromFile = br.readLine();
            }
            hm.forEach((k, v) -> System.out.println(k + " : " + v));
            System.out.println(Collections.max(hm.values()));

            Map<String, Integer> hm1 = new HashMap<String, Integer>();
            hm.entrySet().stream()
                    .filter(entry -> entry.getValue() == Collections.max(hm.values()))
                    .forEach(entry -> hm1.put(entry.getKey(), entry.getValue()));

            System.out.println("---------------------------------------------------");

            hm1.forEach((k, v) -> System.out.println(k + ":" + v));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
