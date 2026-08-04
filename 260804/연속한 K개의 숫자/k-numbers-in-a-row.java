import java.util.Scanner;

// 연속한 K개의 숫자들이 최소 한 세트는 존재하게 하려할 때, 현재 없는
// B개의 숫자들 중 추가해야 하는 숫자 개수의 최솟값을 구하는 프로그램
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1~n까지의 수
        int k = sc.nextInt(); // k개가 연속되어야함
        int b = sc.nextInt(); //빠진 b개의 숫자들 수
        int[] missingNumbers = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            missingNumbers[i] = 1;
        }
        for (int i = 0; i < b; i++) {
            int missingNum = sc.nextInt();
            missingNumbers[missingNum] = 0; // 구멍난 숫자는 0
        }

        int[] prefixSum = new int[n + 1]; // 빠진 숫자들의 누적 갯수 합
        prefixSum[0] = 0;

        // 빠진 숫자들의 누적 합 작성
        for(int i = 1; i <= n; i++) {
            if(missingNumbers[i] == 0) {
                prefixSum[i] = prefixSum[i-1] + 1;
            } else {
                prefixSum[i] = prefixSum[i-1];
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = k + 1; i <= n; i++) {
            ans = Math.min(ans, prefixSum[i] - prefixSum[i-k]);
        }

        System.out.println(ans);
    }
}