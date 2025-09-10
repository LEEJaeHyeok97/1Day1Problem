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
        int cnt = 2;
        for(int i = 0; i < n*(m+4); i++) {
            x = x + dx[d];
            y = y + dy[d];

            if(inRange(x, y) && graph[x][y] == 0) {
                graph[x][y] = cnt++;
            } else {
                x = x - dx[d];
                y = y - dy[d];
                d = (d + 1) % 4;
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