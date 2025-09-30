import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] *= 2;

            for(int j = 0; j < n; j++) {
                int diffSum = 0;
                for(int k = 0; k < n -1; k++) {
                    if(j == k) continue;
                    diffSum += Math.abs(arr[k] - arr[k+1]);
                }
                ans = Math.min(ans, diffSum);
            }


            arr[i] /= 2;
        }

        System.out.println(ans);
    }
}