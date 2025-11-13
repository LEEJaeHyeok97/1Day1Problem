import java.util.Scanner;
public class Main {
    static final int MAX_NUM = 10000;
    static final int MAX_K = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < MAX_NUM - 1; i++) {
            int tmp = 0;
            for(int j = 0; j < n; j++) {
                if(arr[j] < i) {
                    tmp += (i - arr[j]);
                } else if(arr[j] > i + k) {
                    tmp += (arr[j] - (i + k));
                }
            }

            ans = Math.min(ans, tmp);
        }

        System.out.println(ans);
    }
}