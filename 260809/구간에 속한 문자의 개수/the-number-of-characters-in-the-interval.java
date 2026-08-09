import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[][][] sum = new int[3][n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            String row = sc.next();
            for(int j = 1; j <= m; j++) {
                for(int t = 0; t < 3; t++) {
                    sum[t][i][j] = sum[t][i-1][j] + sum[t][i][j-1] - sum[t][i - 1][j - 1];
                }
                sum[row.charAt(j - 1) - 'a'][i][j]++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int q = 0; q < k; q++) {
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();

            for(int t= 0; t < 3; t++) {
                int cnt = sum[t][r2][c2] - sum[t][r1-1][c2]
                - sum[t][r2][c1-1] + sum[t][r1-1][c1-1];
                sb.append(cnt + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}