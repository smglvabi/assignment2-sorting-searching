import java.util.Scanner;

public class Main {

    static int countUpper(String s, int index) {

        if (index == s.length()) {
            return 0;
        }

        char c = s.charAt(index);

        if (Character.isUpperCase(c)) {
            return 1 + countUpper(s, index + 1);
        }

        return countUpper(s, index + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(countUpper(s, 0));

    }
}