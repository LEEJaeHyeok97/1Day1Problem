import java.util.*;
// 2N 정수 겹치지 않으면서 2개의 원소가 하나의 그룹을 이루도록
// N개의 그룹 . 각 그룹 내 2개의 수 차이 중 최솟값이  최대가 되도록 하시오.
// 2 5 7 9 10 15
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        Arrays.sort(arr);

        // for (int i = 0; i < 2 * n; i++)
            // System.out.print(arr[i] + " ");
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int tmp = Math.abs(arr[i] - arr[i+n]);
            // System.out.println(arr[i] + " " + arr[i+n]);
            ans = Math.min(ans, tmp);
        }

        System.out.println(ans);
    }
}