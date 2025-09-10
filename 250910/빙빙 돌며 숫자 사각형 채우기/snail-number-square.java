import java.util.Scanner;
public class Main {
    
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.

        int[][] graph = new int[n][m];
        int x = 0;
        int y = 0;
        int d = 1;
        graph[x][y] = 1;
        for(int i = 2; i <= n*m; i++) {
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if(!inRange(nextX, nextY) || graph[nextX][nextY] != 0)
                d = (d + 1) % 4;
            x = x + dx[d]; y = y + dy[d];
            graph[x][y] = i;
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