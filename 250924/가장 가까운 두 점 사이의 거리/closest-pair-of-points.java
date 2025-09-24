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
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int nx = (x[i] - x[j]) * (x[i] - x[j]);
                int ny = (y[i] - y[j]) * (y[i] - y[j]);

                ans = Math.min(ans, nx + ny);
            }
        }

        System.out.println(ans);
    }
}