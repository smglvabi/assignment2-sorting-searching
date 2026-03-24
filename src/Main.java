import java.util.Scanner;

public class Main {

    static void readArray(int[] arr, int index, Scanner sc) {

        if (index == arr.length) {
            return;
        }

        arr[index] = sc.nextInt();

        readArray(arr, index + 1, sc);
    }

    static void reverse(int[] arr, int index) {

        if (index == arr.length) {
            return;
        }

        reverse(arr, index + 1);

        System.out.print(arr[index] + " ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        readArray(arr, 0, sc);

        reverse(arr, 0);

    }
}