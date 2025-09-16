import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < n - 1; i++) {
            int tmp = 0;
            int curX = 0; int curY = 0;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                else {
                    tmp += Math.abs(curX - x[j]) + Math.abs(curY - y[j]);
                    curX = x[j]; curY = y[j];
                }
            }
            ans = Math.min(ans, tmp);
        }

        System.out.println(ans);
    }
}