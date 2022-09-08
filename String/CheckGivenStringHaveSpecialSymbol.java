import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class CheckGivenStringHasSpecialSymbol {

    public static boolean stringHaveSpecialSymbol(String input) {
        char[] charArrayOfInputString = input.toCharArray();
        for (int index = 0; index < charArrayOfInputString.length; index++) {
            if (!Character.isLetter(charArrayOfInputString[index])) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkStringHaveSpecialSymbolUsingRegex(String input) {
        Pattern pattern = Pattern.compile("[^A-Za-z]");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return true;
        }

        return false;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String Here---->");
        String input = sc.nextLine();
        // System.out.println(stringHaveSpecialSymbol(input));

        System.out.println(checkStringHaveSpecialSymbolUsingRegex(input));
    }

}
