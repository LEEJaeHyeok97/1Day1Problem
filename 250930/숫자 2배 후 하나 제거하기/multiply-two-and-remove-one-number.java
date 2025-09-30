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
                    diffSum += Math.abs(arr[k] - arr[k+1]);
                }
                if(j == 0){
                    diffSum -= Math.abs(arr[1]-arr[0]);
                }
                else if(j == n-1) {
                    diffSum -= Math.abs(arr[n-1] - arr[n-2]);
                }
                else {
                    diffSum -= (Math.abs(arr[j] - arr[j-1]) + Math.abs(arr[j+1] - arr[j]));
                    diffSum += (Math.abs(arr[j-1] - arr[j+1]));
                }

                ans = Math.min(ans, diffSum);
            }


            arr[i] /= 2;
        }

        System.out.println(ans);
    }
}