import java.util.Scanner;
public class Main {

    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int target = sc.nextInt();

            int idx = binarySearch(target);
            System.out.println(idx);
        }
    }

    static int binarySearch(int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid + 1;
            }

            if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}