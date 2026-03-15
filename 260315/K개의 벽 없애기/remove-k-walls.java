import java.util.*;

// n * n 격자
// K개의 벽을 없애 시작점으로부터 도착점까지 도달하는 데 걸리는 시간을 최소로하는 프로그램
// 0은 이동 가능, 1은 이동 불가(벽)
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
    static int ans = Integer.MAX_VALUE;
    static int[][] grid;
    static boolean[][] visited;
    static int[][] tmpGrid;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int r1, c1, r2, c2;
    static ArrayList<Integer> selected = new ArrayList<>();
    static ArrayList<Pair> wall = new ArrayList<>();
    static Deque<Pair> q = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt(); // 없애야할 벽의 개수
        grid = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) {
                    wall.add(new Pair(i, j));
                }
            }
        }
        r1 = sc.nextInt()-1;
        c1 = sc.nextInt()-1;
        r2 = sc.nextInt()-1;
        c2 = sc.nextInt()-1;

        backtracking(0, 0);

        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static void backtracking(int curNum, int cnt) {
        if(selected.size() == k) {
            // 벽을 제거한 임시 그리드
            tmpGrid = new int[n][n];
            for (int i = 0; i < n; i++) {
                tmpGrid[i] = grid[i].clone();
            }

            for(int i = 0; i < selected.size(); i++) {
                Pair p = wall.get(selected.get(i));
                tmpGrid[p.x][p.y] = 0;
            }

            q.clear();
            resetVisited();

            tmpGrid[r1][c1] = 0;
            q.add(new Pair(r1, c1));
            visited[r1][c1] = true;
            bfs();

            return;
        }

        if(curNum == wall.size()) return;

        // 해당 숫자를 추가하지 않는 경우
        backtracking(curNum + 1, cnt);
        // 해당 숫자를 추가하는 경우
        selected.add(curNum);
        backtracking(curNum + 1, cnt + 1);
        selected.remove(selected.size() - 1);
    }

    static void bfs() {
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx, ny)) {
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = true;
                    tmpGrid[nx][ny] = tmpGrid[x][y] + 1;
                }
            }
        }

        // System.out.println("======");
        // for(int i = 0; i < selected.size(); i++) {
        //     System.out.print(selected.get(i) + " ");
        // }
        // System.out.println();
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j++) {
        //         System.out.print(tmpGrid[i][j] + " ");
        //     }

        //     System.out.println();
        // }

        if(tmpGrid[r2][c2] == 0) return;
        else ans = Math.min(ans, tmpGrid[r2][c2]);
    }

    static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(visited[x][y]) return false;
        if(tmpGrid[x][y] == 1) return false;
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