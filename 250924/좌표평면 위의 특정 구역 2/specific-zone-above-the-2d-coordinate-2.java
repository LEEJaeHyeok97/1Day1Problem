import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int maxX = Integer.MIN_VALUE; int maxY = Integer.MIN_VALUE; 
            int minX = Integer.MAX_VALUE; int minY = Integer.MAX_VALUE;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;

                maxX = Math.max(x[j], maxX);
                maxY = Math.max(y[j], maxY);
                minX = Math.min(x[j], minX);
                minY = Math.min(y[j], minY);
            }

            ans = Math.min(ans, (maxX - minX) * (maxY - minY));
        }

        if(ans == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(ans);
    }
}