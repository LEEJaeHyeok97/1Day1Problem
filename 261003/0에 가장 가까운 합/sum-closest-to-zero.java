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
        int left = 0, right = n - 1;
        long ans = Long.MAX_VALUE;

        while(left < right) {
            long sum = arr[left] + arr[right];
            ans = Math.min(ans, Math.abs(sum));
            if(sum < 0) left++;
            else right--;
        }

        System.out.println(ans);
    }
}