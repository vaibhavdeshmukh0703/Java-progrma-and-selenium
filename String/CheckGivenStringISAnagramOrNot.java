package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class CheckGivenStringISAnagramOrNot {

    public static boolean isAnagram(String stringFirst, String stringSecond) {
        String s1 = stringFirst.trim();
        String s2 = stringSecond.trim();
        if (s1.length() != s2.length()) {
            return false;
        } else {
            char[] charString1 = s1.toCharArray();
            char[] charString2 = s2.toCharArray();
            Arrays.sort(charString1);
            Arrays.sort(charString2);
            return Arrays.equals(charString1, charString2);
        }

    }

    public static boolean isAnagramUsingHashMap(String firstSrString, String secondString) {
        String s1 = firstSrString.trim();
        String s2 = secondString.trim();

        if (s1.length() != s2.length()) {

            return false;
        }
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        hm = insertKeyValue(hm, s1);
        hm = insertKeyValue(hm, s2);

        Set<Character> keys = hm.keySet();
        System.out.println(keys);
        for (Character key : keys) {
            if (hm.get(key) != 2) {
                return false;
            }
        }
        return true;

    }

    public static HashMap<Character, Integer> insertKeyValue(HashMap<Character, Integer> hm, String s1) {
        for (int i = 0; i < s1.length(); i++) {
            if (!hm.containsKey(s1.charAt(i))) {
                hm.put(s1.charAt(i), 1);

            } else {
                hm.computeIfPresent(s1.charAt(i), (k, v) -> v + 1);
            }
        }
        return hm;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("silent ", "listen"));
        System.out.println(isAnagramUsingHashMap("silent", "listnn"));
    }

}
