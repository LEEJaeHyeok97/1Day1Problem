import java.util.Scanner;
public class Main {
    static int[] dx = new int[]{1, 0, -1, 0}; // 하 우 상 좌
    static int[] dy = new int[]{0, 1, 0, -1};

    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.
        int[][] graph = new int[n][m];
        int time = 1;
        int d = 0;
        int x =0; int y = 0;
        graph[x][y] = time++;
        for(int i = 1; i < n * m; i++) {
            int curX = x + dx[d]; int curY = y + dy[d];
            if(!inRange(curX, curY) || graph[curX][curY] != 0) {
                d = (d + 1) % 4;
                x = x + dx[d];
                y = y + dy[d];
                graph[x][y] = time++;
            } else {
                x = curX;
                y = curY;
                graph[x][y] = time++;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}