import java.util.*;

// N개의 정수
// 서로 다른 두 개의 위치를 골라 합이 0에 가장 가깝게 만드는 프로그램
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        int i = 0;
        int j = n-1;
        // -123 1 1 2 2 124
        while(i < j) {
            ans = Math.min(ans, Math.abs(arr[i] + arr[j]));
            if(arr[i] + arr[j] < 0) {
                i++;
            } else if(arr[i] + arr[j] > 0) {
                j--;
            } else break;
        }

        System.out.println(ans);
    }
}