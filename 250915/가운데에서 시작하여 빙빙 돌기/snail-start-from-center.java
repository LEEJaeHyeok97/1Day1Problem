import java.util.Scanner;

public class Main {
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dy = new int[]{-1, 0, 1, 0};

    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        // Please write your code here.
        int[][] graph = new int[n][n];
        int curX = n - 1; int curY = n - 1;
        int time = n*n;
        int d = 0;
        graph[curX][curY] = time--;

        for(int i = 1; i < n*n; i++) {
            int nx = curX + dx[d];
            int ny = curY + dy[d];

            if(!inRange(nx, ny) || graph[nx][ny] != 0) {
                d = (d + 1) % 4;

                nx = curX + dx[d];
                ny = curY + dy[d];
                graph[nx][ny] = time--;
            } else {
                graph[nx][ny] = time--;
            }

            curX = nx;
            curY = ny;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}