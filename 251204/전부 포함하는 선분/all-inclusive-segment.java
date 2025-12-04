import java.util.Scanner;
public class Main {
    static int[] x1;
    static int[] x2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        x1 = new int[n];
        x2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int maxX = Integer.MIN_VALUE;
            int minX = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                maxX = Math.max(maxX, x2[j]);
                minX = Math.min(minX, x1[j]);
            }

            ans = Math.min(ans, maxX-minX);
        }

        System.out.println(ans);
    }
}