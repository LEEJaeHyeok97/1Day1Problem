import java.util.Scanner;
// 1 2 4 3
// 2 4 1 3
// 4 1 2 3
// 1 2 3 4
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int idx = n - 1;
        while(idx > 0 && arr[idx - 1] <= arr[idx]) {
            idx--;
        }

        System.out.println(idx);
    }
}