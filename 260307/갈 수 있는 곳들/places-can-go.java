import java.util.*;

// N x N 격자. K개의 시작점-> 상하좌우 인접한 곳으로만 이동하여 도달 가능한 칸의 수
// 0은 이동 가능, 1은 이동할 수 없음.
// 시작지점으로부터 방문이 가능한 서로 다른 칸의 수를 출력.
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    
    static int n, k;
    static int[][] grid;

    static boolean[][] visited;
    static boolean[][] everVisited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Deque<Pair> q = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        everVisited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        for (int i = 0; i < k; i++) {
            resetVisited();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            q.add(new Pair(x, y));
            visited[x][y] = true;
            everVisited[x][y] = true;

            bfs();
        }

        System.out.println(calcEverVisited());
    }

    static void bfs() {
        while(!q.isEmpty()) {
            Pair pair = q.poll();

            int x = pair.x;
            int y = pair.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                    everVisited[nx][ny] = true;
                }
            }
        }
    }

    static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(grid[x][y] == 1) return false;
        if(visited[x][y] == true) return false;
        return true;
    }

    static boolean inRange(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < n);
    }

    static int calcEverVisited() {
        int tmp = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(everVisited[i][j] == true) tmp++;
            }
        }

        return tmp;
    }

    static void resetVisited() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }
}