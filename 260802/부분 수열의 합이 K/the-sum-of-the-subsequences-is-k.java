import java.util.Scanner;
public class Main {
    static int[] prefixSum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n + 1];
        prefixSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            arr[i] = sc.nextInt();
        }

        prefixSum[0] = 0;
        for(int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = i; j <= n; j++) {
                if(getSum(i, j) == k)
                    ans++;
            }
        }
        
        System.out.println(ans);
    }

    static int getSum(int s, int e) {
        return prefixSum[e] - prefixSum[s - 1];
    }
}