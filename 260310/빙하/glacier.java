import java.util.*;

// n*m 빙하
// 빙하를 제외한 곳은 전부 물
// 1: 빙하, 0: 물
// 빙하는 1초에 한 번씩 물에 닿아있는 부분들이 동시에 녹는다.
// 빙하로 둘러쌓인 물은 빙하를 녹이지 못한다.
// 빙하가 전부 녹는데 걸리는 시간 , 마지막으로 녹은 빙하의 크기(1의 개수)를 구하는 프로그램
class Pair {
    int x;
    int y;

    public Pair(x, y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int n, m;

    static int t, lastMeltCnt;
    static int[][] grid;
    static boolean flag = true;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static boolean[][] visited;
    static Deque<Pair> willRemove = new ArrayDeque<>();
    static Deque<Pair> q = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        // 0,0에서 빙하가 다 녹을때까지 bfs 반복.
        t = 0;
        lastMeltCnt = 0;
        visited = new boolean[n][m];
        while(flag) {
            q.clear();
            q.add(new Pair(0, 0));
            resetVisited();
            bfs();
        }

        System.out.println(t + " " + lastMeltCnt);
    }

    static void bfs() {
        int tmpCnt = 0;
        willRemove.clear();

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    if(grid[nx][ny] == 1) {
                        tmpCnt++;
                        willRemove.add(new Pair(nx, ny));
                    } else {
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
        
        while(!willRemove.isEmpty()) {
            Pair p = willRemove.poll();
            grid[p.x][p.y] = 0;
        }
        if(tmpCnt == 0) {
            flag = true;
            return;
        }
        lastMetlCnt = tmpCnt;
        t+=1;
    }

    static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(visited[x][y]) return false;

        return true;
    }

    static boolean inRange(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < m);
    }

    static void resetVisited() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }
}