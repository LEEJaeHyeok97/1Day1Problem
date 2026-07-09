import java.util.Scanner;

// 최장 공통 부분 수열 
// 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int[][] dp = new int[a.length() + 1][b.length() + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= b.length(); i++) {
            dp[0][i] = 0;
        }
        for(int i = 1; i <= a.length(); i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= a.length(); i++) {
        for (int j = 1; j <= b.length(); j++) {
            if (a.charAt(i - 1) == b.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = a.length(), j = b.length();
        while(i > 0 && j > 0) {
            if(a.charAt(i-1) == b.charAt(j-1)) {
                sb.append(a.charAt(i-1));
                i--;
                j--;
            } else if(dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println(sb.reverse());
    }
}