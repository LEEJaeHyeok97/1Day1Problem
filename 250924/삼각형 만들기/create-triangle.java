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
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    int cnt = 0;
                    int x1 = x[i]; int y1 = y[i];
                    int x2 = x[j]; int y2 = y[j];
                    int x3 = x[k]; int y3 = y[k];

                    if(x1 == x2 || x2 == x3 || x1 == x3) cnt++;
                    if(y1 == y2 || y2 == y3 || y1 == y3) cnt++;

                    if(cnt == 2) {
                        int maxX = Math.max(x1, Math.max(x2, x3));
                        int maxY = Math.max(y1, Math.max(y2, y3));
                        int minX = Math.min(x1, Math.min(x2, x3));
                        int minY = Math.min(y1, Math.min(y2, y3));

                        int tmp = (maxX - minX) * (maxY - minY);
                        ans = Math.max(ans, tmp);
                    }   
                }
            }
        }

        System.out.println(ans);
    }
}