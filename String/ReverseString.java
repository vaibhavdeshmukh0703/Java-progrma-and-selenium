package String;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        int s1 = 010;

         revrseWord(s1);
       // reverseHoleString(s1);
        // reverseTheOrderOfString(s1);
        // countWovelsAndConsonant("Reverse");
        // sortString("computer");
        // char[] charArray = s1.toCharArray();
        // for (int i = charArray.length - 1; i >= 0; i--) {
        // System.out.print(charArray[i]);
        // }

    }

    public static void revrseWord(int number) {
        String string = String.valueOf(number);
        System.out.println(string);
        String[] word = string.split(" ");// word = 2
        System.out.println(Arrays.toString(word));

        System.out.println("----------------------Reverse the Word direction----------------------------");
        String temp = "";
        for (String s : word) {
            for (int i = s.length() - 1; i >= 0; i--) {
                temp = temp + s.charAt(i);
            }
            System.out.print(temp + " ");
            temp = "";

        }
        System.out.println();
    }

    public static void reverseHoleString(String s) {
       
       
        String temp = "";
        System.out.println("----------------Reverse Hole string------------");
        for (int i = s.length() - 1; i >= 0; i--) {
            temp = temp + s.charAt(i);
        }
        System.out.print(temp);
        System.out.println();
    }

    public static void reverseTheOrderOfString(String string) {
        // input : "He Is The One"
        // output : "One The Is He"
        System.out.println("--------------Reverse The Order Of String-------------------------------");
        String[] SpliteWord = string.split(" ");
        for (int i = SpliteWord.length - 1; i >= 0; i--) {
            System.out.print(SpliteWord[i] + " ");
        }
        System.out.println();

    }

    public static boolean isWovel(Character ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public static void countWovelsAndConsonant(String s1) {
        // vaibhav owels = 2 consonant = 3
        System.out.println("---------------From Count wovels and Consonant--------------");
        int wovelCount = 0, consonantWovel = 0;
        String string = s1.replaceAll("\\s", "").toLowerCase();

        for (int i = 0; i < string.length(); i++) {
            if (isWovel(string.charAt(i))) {
                wovelCount++;
            } else {
                consonantWovel++;
            }
        }
        System.out.println(
                " Wovel Count from String is" + wovelCount + " Consonant Count from String is" + consonantWovel);
    }

    public static void sortString(String string) {
        System.out.println("------------------Sorted String--------------------");
        char[] ch = string.toCharArray();
        Arrays.sort(ch);
        System.out.println(new String(ch));

    }
}
