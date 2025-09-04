import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max_cnt = 1;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                max_cnt = Math.max(cnt, max_cnt);
                cnt = 1;
            } else {
                cnt += 1;
            }
        }

        System.out.println(max_cnt);
    }
}