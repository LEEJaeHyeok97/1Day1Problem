import java.util.Scanner;

// x 중에서 최초로 등장하는 위치 -> lowerbound
public class Main {
    static int n, m;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            lowerBound(x);
        }
    }

    static void lowerBound(int target) {
        int left = 0;
        int right = n-1;
        int idx = n;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target) {
                if(arr[mid] == target) {
                    idx = Math.min(idx, mid);
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(idx == n) System.out.println(-1);
        else System.out.println(idx + 1);
    }
}