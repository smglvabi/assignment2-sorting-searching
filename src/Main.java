import java.util.Scanner;

public class Main {

    static boolean onlyDigits(String s, int index) {
        if (index == s.length()) {
            return true;
        }

        if (!Character.isDigit(s.charAt(index))) {
            return false;
        }

        return onlyDigits(s, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        if (onlyDigits(s, 0)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}