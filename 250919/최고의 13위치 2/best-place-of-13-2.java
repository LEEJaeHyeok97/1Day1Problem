import java.util.Scanner;
public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();
        // Please write your code here.
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 2; j++) {
                int tmp1 = arr[i][j]; int tmp2 = arr[i][j+1]; int tmp3 = arr[i][j+2];
                arr[i][j] = 3; arr[i][j+1] = 3; arr[i][j+2] = 3;

                for(int k = 0; k < n; k++) {
                    for(int s = 0; s < n - 2; s++) {
                        if(inRange(k, s) && (arr[k][s] != 3 && arr[k][s+1] != 3 && arr[k][s+2] != 3)) {
                            ans = Math.max(ans, tmp1 + tmp2 + tmp3 + arr[k][s] + arr[k][s+1] + arr[k][s+2]);
                        }
                    }
                }

                arr[i][j] = tmp1; arr[i][j+1] = tmp2; arr[i][j+2] = tmp3;
            }
        }
        System.out.println(ans);
    }
    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}