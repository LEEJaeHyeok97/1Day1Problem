import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        // Please write your code here.
        int ans = Integer.MIN_VALUE;
        for(int i = x; i <= y; i++) {
            int a = i / 10000;
            int b = i / 1000 % 10;
            int c = i / 100 % 10;
            int d = i / 10 % 10;
            int e = i % 10;

            ans = Math.max(ans, a+b+c+d+e);
        }

        System.out.println(ans);
    }
}