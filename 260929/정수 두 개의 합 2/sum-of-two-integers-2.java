import java.util.*;

// n개의 정수가 주어졌을 때, 
// 두 개의 원소를 골라 그 합이 K 이하가 되는 경우의 수를 구하는 프로그램
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int j = 1;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            while(j < n && arr[i] + arr[j] <= k) {
                j++;
                ans++;
            }

            j = i + 2;
            if(i == j) break;
        }

        System.out.println(ans);
    }
}