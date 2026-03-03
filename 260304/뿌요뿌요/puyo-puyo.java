import java.util.Scanner;

// 각 칸에 1이상 100이하의 정수가 적힌 N * N 격자
// 상하좌우로 인접한 칸끼리 같은 숫자로 이루어져 있는 경우 하나의 블록
// 블럭을 이루는 칸의 수가 4개 이상인 경우 터진다.
// 초기 상태가 주어졌을 때 터지는 블록은 몇 개인지, 가장 큰 블록은 크기는 얼마인지 출력
public class Main {

    static int n;
    static int[][] grid;

    static int maxSize = 0;
    static int cnt = 0;
    static int tmpBlockSize;
    static int curState;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    curState = grid[i][j];
                    tmpBlockSize = 1;
                    visited[i][j] = true;

                    dfs(i, j);
                    maxSize = Math.max(maxSize, tmpBlockSize);
                    if(tmpBlockSize >= 4) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt + " " + maxSize);
    }

    static void dfs(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(canGo(nx, ny)) {
                tmpBlockSize++;
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    static boolean canGo(int x, int y) {
        if(inRange(x, y) && grid[x][y] == curState && !visited[x][y]) return true;
        return false;
    }

    static boolean inRange(int x, int y) {
        if((0 <= x && x < n) && (0 <= y && y < n)) return true;
        return false;
    }
}