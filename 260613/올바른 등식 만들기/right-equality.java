import java.util.Scanner;

// N개 0~9 숫자들이 주어진다, 각 숫자를 더하거나 빼서 그 합이 M이 되도록하는
// 서로 다른 가짓수를 구하는 프로그램을 작성해보세요.(그 결과가 -20보다 작아지거나 20보다 커지면 안된다.)
// ㄱ
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        // Please write your code here.
        long[][] dp = new long[N + 1][41];
        dp[0][20] = 1;
        for(int i = 1; i < N + 1; i++) {
            for(int j = 0; j <= 40; j++) {
                if(j - numbers[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - numbers[i-1]];
                }
                if(j + numbers[i - 1] <= 40) {
                    dp[i][j] += dp[i - 1][j + numbers[i-1]];
                }
            }
        }

        System.out.println(dp[N][M + 20]);
    }
}