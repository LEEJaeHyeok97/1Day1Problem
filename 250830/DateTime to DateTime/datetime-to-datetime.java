import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.
        
        int ans = 0;

        ans += (A - 11) * 24 * 60;
        ans += (B - 11) * 60;
        ans += C - 11;

        if (ans < 0) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}