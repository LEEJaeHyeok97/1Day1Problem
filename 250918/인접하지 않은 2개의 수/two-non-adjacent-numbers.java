import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i + 2; j < n; j++) {
                int tmp = arr[i] + arr[j];
                ans = Math.max(ans, tmp);
            }
        }

        System.out.println(ans);
    }
}