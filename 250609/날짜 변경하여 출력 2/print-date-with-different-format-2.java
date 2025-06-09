import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String[] li = sc.next().split("-");

        System.out.printf("%s.%s.%s", li[2], li[0], li[1]);
    }
}