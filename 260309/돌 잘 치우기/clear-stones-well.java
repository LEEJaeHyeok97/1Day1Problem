import java.util.*;

// n * n 격자. 1은 돌 0은 이동가능
// M개의 돌만 적절하게치워 K개의 시작지점으로부터 도달 가능한 칸의 수를 최대로 하는 프로그램
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int ans = 0;
    static int n, k, m;

    static int[][] grid;
    static int[][] startPoints;
    static boolean[][] visited;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static Deque<Pair> q = new ArrayDeque<>();
    static ArrayList<Integer> selected = new ArrayList<>();
    static ArrayList<Pair> stones = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt() - 1;
            startPoints[i][1] = sc.nextInt() - 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    stones.add(new Pair(i, j));
                }
            }
        }

        backtracking(0, 0); // 제거할 돌을 조합으로 가져온다.
        // 없앨 돌 조합 횟수만큼 제거한 경우의 bfs값을 ans에 갱신한다. - 백트래킹 안에서 m개 돌을
        // 뽑은 경우에 시행. (bfs())


        System.out.println(ans);
    }

    static void backtracking(int curNum, int cnt) {
        if(selected.size() == m) {
            // for(int z = 0; z < selected.size(); z++) {
            //     System.out.print(selected.get(z) + " ");
            // }
            // System.out.println();
            // System.out.println("=====");

            for(int i = 0; i < m; i++) {
                Pair p = stones.get(selected.get(i));
                int r = p.x;
                int c = p.y;
                
                resetVisited();
                q.clear();

                q.add(new Pair(r, c));
                visited[r][c] = true;
                bfs();
            }

            return;
        }

        if(curNum == stones.size()) return;

        selected.add(curNum);
        backtracking(curNum + 1, cnt + 1);
        selected.remove(selected.size() - 1);
        backtracking(curNum + 1, cnt);
    }

    static void bfs() {
        // 돌 치우기
        for(int i = 0; i < selected.size(); i++) {
            int idx = selected.get(i);
            Pair tmpPair = stones.get(idx);
            grid[tmpPair.x][tmpPair.y] = 0;
        }

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx, ny)) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }

        // 돌 다시 가져다두기
        for(int i = 0; i < selected.size(); i++) {
            int idx = selected.get(i);
            Pair tmpPair = stones.get(idx);
            grid[tmpPair.x][tmpPair.y] = 1;
        }

        ans = Math.max(ans, countVisited());
    }

    static void resetVisited() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
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

    static int countVisited() {
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == true) cnt++;
            }
        }

        return cnt;
    }
}