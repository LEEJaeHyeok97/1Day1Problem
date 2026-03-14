import java.util.*;

// N * N 격자. H 명의 사람이 겹치지 않게 서 있다.
// 비를 피할 수 있는 공간의 위치 M개
// 각 사람마다 비를 피할 수 있는 가장 가까운 공간까지의 거리를 구하는 프로그램을 작성.
// 숫자 0은 해당 칸이 이동할 수 있는 곳, 숫자 1은 벽이 있는 곳, 숫자 2는 사람이 있음
// 숫자 3은 해당 공간이 비를 피할 수 있는 공간임을 의미.
// 벽이 아닌 곳은 전부 이동이 가능.
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int n, h, m;
    static int startX, startY;
    static int[][] grid;
    static boolean[][] visited;
    static int[][] dist;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Deque<Pair> q = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    resetVisited();
                    q.clear();

                    startX = i; startY = j;
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                    bfs();
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(dist[i][j] + " ");
            }

            System.out.println();
        }
    }

    static void bfs() {
        
        int[][] tmpGrid = new int[n][n];
        while(!q.isEmpty()) {
            Pair p = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(canGo(nx, ny)) {
                    tmpGrid[nx][ny] = tmpGrid[p.x][p.y] + 1;
                    if(grid[nx][ny] == 3) {
                        dist[startX][startY] = tmpGrid[nx][ny];
                        return;
                    }
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }

        dist[startX][startY] = -1;
    }

    static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(visited[x][y]) return false;
        if(grid[x][y] == 1) return false;
        return true;
    }

    static boolean inRange(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }

    static void resetVisited() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }
}