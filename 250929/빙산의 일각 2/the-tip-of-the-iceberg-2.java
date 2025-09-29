import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        int peak = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
            peak = Math.max(peak, h[i]);
        }
        // Please write your code here.
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < peak; i++) {
            int cnt = 0;
            boolean link = false;
            for(int j =0; j < n; j++) {
                if(h[j] > i && link) {
                    continue;
                }
                if(h[j] > i) {
                    link = true;
                    cnt++;
                    continue;
                }
                if(h[j] <= i) {
                    link = false;
                    continue;
                }
            }
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}