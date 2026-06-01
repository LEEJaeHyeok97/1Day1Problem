import java.util.*;
// N개의 수가 주어졌을 때 A, B, C로 나누어 A합 == B합이 최대가 되도록하시오.
// N개의 수는 각 정확히 한 곳에만 속해야 한다. 아무 수도 포함하고 있지 않은 그룹 내 수 합 0
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

        int offset = s; // 음수 인덱스 처리
        int[] dp = new int[2 * s + 1]; // diff 범위: -s ~ +s
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[offset] = 0;

        for(int i = 0; i < n; i++) {
            int[] next = new int[2 * s + 1];
            Arrays.fill(next, Integer.MIN_VALUE);
            for(int d = 0; d <= s*2; d++) {
                if(dp[d] == Integer.MIN_VALUE) continue;
                int aSum = dp[d];

                next[d + arr[i]] = Math.max(next[d + arr[i]], aSum + arr[i]);
                next[d - arr[i]] = Math.max(next[d - arr[i]], aSum);
                next[d] = Math.max(next[d], aSum);
            }
            dp = next;
        }

        System.out.println(dp[offset]);
    }
}