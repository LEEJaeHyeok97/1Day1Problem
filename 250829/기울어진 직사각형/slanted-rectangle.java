import java.util.Scanner;

public class Main {

    static final int DIR_NUM = 4;
    static final int MAX_N = 20;

    static int n;
    static int[][] graph = new int[MAX_N][MAX_N];

    static boolean isRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    for (int l = 1; l < n; l++) {
                        ans = Math.max(ans, getScore(i, j, k, l));
                    }
                }
            }
        }

        System.out.print(ans);
    }

    static int getScore(int x, int y, int k, int l) {
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {1, -1, -1, 1};
        int[] moveNum = {k, l, k, l};

        int sumOfNums = 0;

        for (int d = 0; d < DIR_NUM; d++) {
            for (int q = 0; q < moveNum[d]; q++) {
                x += dx[d]; y += dy[d];

                if (!isRange(x, y)) {
                    return 0;
                }

                sumOfNums += graph[x][y];
            }
        }
        return sumOfNums;
    }
}
