import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seats = sc.next();
        // Please write your code here.
        char[] arr = seats.toCharArray();
        System.out.println(arr);
    }
}