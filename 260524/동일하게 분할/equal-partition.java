import java.util.Scanner;

// N개의 수가 주어졌을 대 2개의 그룹으로 나눠 각 그룹의 합이 일치하는 프로그램을 작성
// N개의 수는 각각 A 또는 B 중 정확히 한 곳에만 속해야 하며, 
// 각 그룹은 최소 1개 이상의 수를 포함하고 있어야 함
// 각 그룹의 수들간의 합을 동일하게 만드는 것이 가능하다면 Yes, 불가능하다면 No
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int s = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            s += arr[i];
        }

        int a = s/2;
        if(s % 2 != 0) {
            System.out.println("No");
            return;
        }

        int[] dp = new int[a + 1];
        for(int i = 0; i <= a; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = a; j > 0; j--) {
                if(j - arr[i] >= 0) {
                    if(dp[j - arr[i]] != Integer.MIN_VALUE) {
                        dp[j] = Math.max(dp[j], dp[j - arr[i]] + arr[i]);
                    }
                }
            }
        }

        // for(int i = 0; i <= a; i++) {
        //     System.out.print(dp[i] + " ");
        // }

        if(dp[a] != Integer.MIN_VALUE) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}