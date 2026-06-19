import java.util.Scanner;
public class Main {
    static void initialize() {
        for(int i = 0; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        for(int j = 1; j < n + 1; j++) {
            if(inRange(1, j)) {
                dp[1][j] = 0;
            }
        }
    }
    
    static int[][] dp;
    static int[] s;
    static int[] e;
    static int[] v;
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        s = new int[n];
        e = new int[n];
        v = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
            e[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        dp = new int[m + 1][n + 1];

        initialize();
        for(int i = 2; i < m + 1; i++) {
            for(int j = 1; j < n + 1; j++) {
                for(int k = 1; k < n + 1; k++) {
                    if(inRange(i, j) && dp[i - 1][k] != Integer.MIN_VALUE) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.abs(v[j - 1] - v[k - 1]));
                    }
                }
            }
        }

        // for(int i = 0; i < m + 1; i++) {
        //     for(int j = 0; j < n + 1; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        int ans = 0;
        for(int i = 0; i < n + 1; i++) {
            ans = Math.max(ans, dp[m][i]);
        }

        System.out.println(ans);
    }

    static boolean inRange(int i, int j) {
        if(i >= s[j - 1] && i <= e[j - 1]) return true;
        return false;
    }
}