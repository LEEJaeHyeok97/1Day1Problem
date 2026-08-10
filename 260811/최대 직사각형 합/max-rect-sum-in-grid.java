import java.util.Scanner;

// -1000 이상 1000 이하 숫자로만 이루어진 N * N 2차원 격자가 주어진다.
// 격자를 벗어나지 않는 직사각형 하나를 적절하게 잡아 사각형 내 숫자들의 합이
// 최대가 되도록 하는 프로그램을 작성하시오.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int ans = Integer.MIN_VALUE;
        for(int top = 0; top < n; top++) {
            int[] colSum = new int[n];
            for(int bottom = top; bottom < n; bottom++) {
                for(int j = 0; j < n; j++) {
                    colSum[j] += grid[bottom][j];
                }

                int cur = colSum[0];
                ans = Math.max(ans, cur);
                for(int j = 1; j < n; j++) {
                    cur = Math.max(colSum[j], cur + colSum[j]);
                    ans = Math.max(ans, cur);
                }
            }
        }

        System.out.println(ans);
    }
}