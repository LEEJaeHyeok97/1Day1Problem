import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // n 자체가 매우 클 수 있으므로 String으로 받아 BigInteger 생성
        // 하지만 배열의 인덱스로 사용하려면 intValue() 변환이 필요합니다.
        int n = sc.nextInt(); 

        if (n < 2) {
            System.out.println(0);
            return;
        }

        // BigInteger 배열 선언
        BigInteger[] dp = new BigInteger[n + 1];

        // 초기값 설정 (BigInteger 객체로 생성)
        dp[0] = BigInteger.ONE;
        if (n >= 1) dp[1] = BigInteger.ZERO;
        if (n >= 2) dp[2] = BigInteger.ONE;
        if (n >= 3) dp[3] = BigInteger.ONE;

        // 바텀업 DP 진행
        for (int i = 4; i <= n; i++) {
            // add 메서드를 사용하여 연산
            dp[i] = dp[i - 2].add(dp[i - 3]);
        }

        // 나머지 연산 (remainder 메서드 사용)
        BigInteger mod = new BigInteger("10007");
        System.out.println(dp[n].remainder(mod));
    }
}
