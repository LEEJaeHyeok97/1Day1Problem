import java.util.Scanner;

// 연속하는 원소들의 합이 M이 되는 경우의 수를 구하시오.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        int j = 0;
        int sumVal = 0;
        for(int i = 0; i < n; i++) {
            while(j < n && sumVal + arr[j] <= m) {
                sumVal += arr[j];
                j++;
            }

            if(sumVal == m) ans++;
            if(j == n) break;
            sumVal -= arr[i];
        }

        System.out.println(ans);
    }
}