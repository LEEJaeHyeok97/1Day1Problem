import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[] num_of_days = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        // Please write your code here.
        
        int ans = 0;
        for(int i = m1; i < m2 + 1; i++) {
            if (i == m1) {
                ans = ans - d1 + 1;
            }
            if (i == m2) {
                ans += d2;
                break;
            }
            ans += num_of_days[i];
        }

        System.out.println(ans);
    }
}