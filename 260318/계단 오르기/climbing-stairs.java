import java.util.Scanner;

// n 층 높이 계단을 오르려고 한다.
// 항상 2계단 혹은 3계단 단위로만 올라갈 수 있다.
// 바텀업 -> dp
// n층 높이의 계단에 올라가기 위한 서로 다른 방법의 수를 10007로 나눈 나머지를 출력.
// 불가능하다면 0을 출력.
public class Main {

    static int[] dp = new int[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i < n + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]);
        }

        System.out.println(dp[n]  % 10007);
    }
}