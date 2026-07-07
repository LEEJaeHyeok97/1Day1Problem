import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        int[][] dp = new int[a.length() + 1][b.length() + 1];
        dp[0][0] = 0;
        for(int i = 1; i <= a.length(); i++) {
            dp[i][0] = i;
        }
        for(int i = 1; i <= b.length(); i++) {
            dp[0][i] = i;
        }

        for(int i = 1; i <= a.length(); i++) {
            for(int j = 1; j <= b.length(); j++) {
                if(a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }

        System.out.println(dp[a.length()][b.length()]);
    }
}