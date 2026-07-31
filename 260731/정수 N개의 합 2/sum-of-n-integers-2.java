import java.util.Scanner;

// K개의 원소의 합 중 가장 큰 값
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] prefixSum = new int[n];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();   
        }

        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i + k - 1 < n; i++) {
            int sum = 0;
            if(i == 0) {
                sum = prefixSum[i + k - 1] - 0;
            } else {
                sum = prefixSum[i + k - 1] - prefixSum[i] + arr[i];
            }
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}