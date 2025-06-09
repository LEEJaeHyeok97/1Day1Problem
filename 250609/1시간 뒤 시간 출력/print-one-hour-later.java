import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String[] li = sc.next().split(":");

        System.out.printf("%s:%s", Integer.parseInt(li[0]) + 1, li[1]);
    }
}