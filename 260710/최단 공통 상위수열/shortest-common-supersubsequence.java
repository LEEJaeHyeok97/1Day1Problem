import java.util.Scanner;

// S T 두 문자열의 가장 짧은 상위 수열의 길이를 찾는 프로그램
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();

        int[][] dp = new int[s.length() + 1][t.length() + 1];

        dp[0][0] = 0;
        for(int i = 1; i <= t.length(); i++) {
            dp[0][i] = i;
        }
        for(int i = 1; i <= s.length(); i++) {
            dp[i][0] = i;
        }

        // 글자가 같으면 dp[i-1][j-1] + 1
        // 글자가 다르면 min(dp[i-1][j], dp[i][j-1]) + 1
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                if(s.charAt(i-1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }

        System.out.println(dp[s.length()][t.length()]);
    }
}