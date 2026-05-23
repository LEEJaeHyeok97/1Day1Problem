import java.util.Scanner;

// 그룹 A, B에 들어있는 수들간의 합 차이의 최소값
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int s = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            s += arr[i];
        }

        // s - 2a : 두 그룹의 각각의 합의 차
        int[] dp = new int[s/2 + 1];
        dp[0] = 0;
        for(int i = 1; i < s/2 + 1; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for(int i = 0; i < n; i++) {
            for(int j = s/2; j >= 0; j--) {
                if(j - arr[i] >= 0) {
                    if(dp[j - arr[i]] != Integer.MIN_VALUE) {
                        dp[j] = Math.max(dp[j], dp[j - arr[i]] + arr[i]);
                    }
                }
            }
        }

        int a = 0;
        for(int i = 0; i < s/2 + 1; i++) {
            a = Math.max(a, dp[i]);
        }

        int ans = s - 2*a;
        System.out.println(ans);
    }   
}