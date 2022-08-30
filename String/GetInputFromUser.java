import java.util.Scanner;

public class GetInputFromUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String Here----->");
        String input = sc.nextLine();
        System.out.println(input);
    }
}
