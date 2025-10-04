import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= 10000; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(i <= arr[j] && Math.abs(i - arr[j]) <= 3)
                    cnt++;
            }

            ans = Math.max(ans, cnt);
        } 
        
        System.out.println(ans);
    }
}