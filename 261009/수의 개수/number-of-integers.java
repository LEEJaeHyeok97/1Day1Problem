import java.util.Scanner;

// upperBound - lowerBound
public class Main {

    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            System.out.println(upperBound(x) - lowerBound(x));
        }
    }

    static int upperBound(int target) {
        int left = 0;
        int right = arr.length - 1;
        int val = arr.length;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] <= target) {
                left = mid + 1;
            } else {
                val = Math.min(val, mid);
                right = mid - 1;
            }
        }

        return val;
    }

    static int lowerBound(int target) {
        int left = 0;
        int right = arr.length - 1;
        int val = arr.length;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] < target) {
                left = mid + 1;
            } else {
                val = Math.min(val, mid);
                right = mid - 1;
            }
        }

        return val;
    }
}