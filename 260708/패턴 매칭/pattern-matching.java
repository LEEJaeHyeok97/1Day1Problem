import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i <= p.length(); i++) {
            if(p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i-2];
            } else {
                dp[0][i] = false;
            }
        }
        for(int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= p.length(); j++) {
                if(s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    if(p.charAt(j - 1) == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    if(p.charAt(j-1) == '*') {
                        dp[i][j] = dp[i][j-2] || (dp[i-1][j] && (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'));
                    }
                }
            }
        }

        System.out.println(dp[s.length()][p.length()]);
    }
}