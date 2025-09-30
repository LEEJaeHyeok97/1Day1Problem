import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            int cur = arr[i];
            int cnt = 0;
            int tmpSum = 0;
            while(cnt < m) {
                cur = arr[cur];
                tmpSum += cur;
                cnt++;
            }

            ans = Math.max(ans, tmpSum);
        }

        System.out.println(ans);
    }
}