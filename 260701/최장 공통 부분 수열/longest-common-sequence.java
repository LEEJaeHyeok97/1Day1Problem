import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();

        char[] chA = A.toCharArray();
        char[] chB = B.toCharArray();
        int[][] dp = new int[chA.length + 1][chB.length + 1];

        // initialize
        dp[1][1] = (chA[0] == chB[0] ? 1 : 0);
        for(int i = 2; i <= chA.length; i++) {
            if(A.charAt(i-1) == B.charAt(0))
                dp[i][1] = 1;
            else
                dp[i][1] = dp[i-1][1];
        }
        for(int j = 2; j <= chB.length; j++) {
            if(B.charAt(j-1) == A.charAt(0))
                dp[1][j] = 1;
            else
                dp[1][j] = dp[1][j-1];
        }

        for(int i = 2; i <= chA.length; i++) {
            for(int j = 2; j <= chB.length; j++) {
                if(A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // for(int i = 0; i < chA.length + 1; i++) {
        //     for(int j = 0; j < chB.length + 1; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(dp[chA.length][chB.length]);
    }
}