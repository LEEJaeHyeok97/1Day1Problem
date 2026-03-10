import java.util.*;

// n * n 격자. 높이 정보. 
// k개의 도시를 겹치지 않게 적절히 골라 k개의 도시로부터 갈 수 있는 서로 다른 도시의 수를 
// 최대화. 
// 두 도시간의 높이의 차가 U이상 D이하 경우에만 가능
// K개의 도시에는 시작도시 포함.
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int n, k, u, d;
    static int ans = 0;
    static int curX = 0;
    static int curY = 0;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Deque<Pair> q = new ArrayDeque<>();
    static boolean[][] visited;
    static int[][] grid;
    static ArrayList<Pair> selected = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[n][n];
        backtracking(0, 0);

        System.out.println(ans);
    }

    static void backtracking(int curNum, int cnt) {
        if(cnt == k) {
            resetVisited();
            q.clear();

            for(int i = 0; i < selected.size(); i++) {
                Pair pair = selected.get(i);
                curX = pair.x;
                curY = pair.y;

                q.add(new Pair(curX, curY));
                visited[curX][curY] = true;
            }

            bfs();
            return;
        }
        if(curNum == n*n) return;

        int x = curNum / n;
        int y = curNum % n;

        backtracking(curNum + 1, cnt);
        selected.add(new Pair(x, y));
        backtracking(curNum + 1, cnt + 1);
        selected.remove(selected.size() - 1);
    }

    static void bfs() {
        int visitCnt = selected.size();
        while(!q.isEmpty()) {
            Pair p = q.poll();

            int x = p.x;
            int y = p.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(canGo(nx, ny, x, y)) {
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    visitCnt++;
                }
            }
        }

        ans = Math.max(ans, visitCnt);
    }

    static boolean canGo(int x, int y, int prevX, int prevY) {
        if(!inRange(x, y)) return false;
        if(visited[x][y]) return false;
        if(!((Math.abs(grid[x][y] - grid[prevX][prevY]) >= u) && Math.abs(grid[x][y] - grid[prevX][prevY]) <= d)) return false;
        return true;
    }

    static void resetVisited() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    static boolean inRange(int x, int y) {
        return (0 <=  x && x < n) && (0 <= y && y < n);
    }
}