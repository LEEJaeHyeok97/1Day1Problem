import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int c2 = sc.nextInt();
        // Please write your code here.
        int cnt = 0; // 1 2 3 4 5 6 7 8 9
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if((Math.abs(a - i) <= 2 || Math.abs(a - i) >= n - 2) && (Math.abs(b - j) <= 2 || Math.abs(b - j) >= n - 2) && (Math.abs(c - k) <= 2 || Math.abs(c - k) >= n - 2))
                        cnt++;
                    else if((Math.abs(a2 - i) <= 2 || Math.abs(a2 - i) >= n - 2) && (Math.abs(b2 - j) <= 2 || Math.abs(b2 - j) >= n - 2) && (Math.abs(c2 - k) <= 2 || Math.abs(c2 - k) >= n - 2))
                        cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}