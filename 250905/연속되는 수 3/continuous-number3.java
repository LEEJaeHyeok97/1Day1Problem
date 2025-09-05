import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        // Please write your code here.
        int cnt = 0;
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] * arr[i - 1] < 0) {
                cnt = 1;
            } else {
                cnt += 1 ;
            }
            maxValue = Math.max(maxValue, cnt);
        }

        System.out.println(maxValue);
    }
}