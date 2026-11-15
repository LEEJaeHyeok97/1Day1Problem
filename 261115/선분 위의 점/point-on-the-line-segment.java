import java.util.*;

public class Main {
    static final int MAX_N = 100000;

    static int n, m;
    static int[] arr = new int[MAX_N];

    static int upperBound(int target) {
        int left = 0, right = n - 1;
        int minIdx = n;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            }
        }

        return minIdx;
    }

    static int lowerBound(int target) {
        int left = 0;
        int right = n - 1;
        int minIdx = n;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target) {
                right = mid - 1;
                minIdx = Math.min(minIdx, mid);
            } else {
                left = mid + 1;
            }
        }

        return minIdx;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int a, b;
        Arrays.sort(arr, 0, n);
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            int res = upperBound(b) - lowerBound(a);
            System.out.println(res);
        }
    }
}