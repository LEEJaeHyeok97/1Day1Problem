import java.util.*;
// N N개의 수
// 3개 골라 곱 중 최대값
// N개의 수 (-1000~1000)
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int[] sortedArr = arr.clone();
        int[] reversedSortedArr = new int[n];
        Arrays.sort(sortedArr);
        // for(int i = 0; i < n; i++) {
        //     System.out.print(sortedArr[i] + " ");
        // }

        // System.out.println();
        int tmp = 0;
        for(int i = n-1; i >= 0; i--) {
            reversedSortedArr[tmp++] = sortedArr[i];
        }
        // for(int i = 0; i < n; i++) {
        //     System.out.print(reversedSortedArr[i] + " ");
        // }
        // 양수 * 양수 * 양수
        // 음수 * 음수 * 양수
        // 0을 포함하는 경우
        // System.out.println();
        int ans = Integer.MIN_VALUE;
        // 양 양 양
        ans = Math.max(ans, reversedSortedArr[0] * reversedSortedArr[1] * reversedSortedArr[2]);
        // 음 음 양
        ans = Math.max(ans, sortedArr[0] * sortedArr[1] * sortedArr[sortedArr.length - 1]);

        System.out.println(ans);
    }
}