import java.util.Scanner;

// n개 원소 수열 특정 구간 합이 s 이상이 되는 것 중, 가장 짧은 구간의 길이
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        int j = -1;
        int sumValue = 0;
        for(int i = 0; i < n; i++) {
            while(j + 1 < n && sumValue < s) {
                sumValue += arr[j + 1];
                j++;
            }

            if(sumValue >= s) {
                ans = Math.min(ans, j + 1 - i);
            }
            sumValue -= arr[i];
        }

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}