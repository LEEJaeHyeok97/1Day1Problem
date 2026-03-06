import java.util.*;

// n * m 크기의 그리드 좌측 상단 -> 우측 하단 탈출
// 상하좌우로만 이동가능, 뱀이 있는 칸으로는 이동을 할 수 없다.
// 뱀이 배치되어 있는 경우 실선과 같은 경로로 탈출할 수 있다.
// 탈출 가능하다면 1, 탈출 경로가 없다면 0
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    } 
}
public class Main {

    static int n, m;

    static int[] dx = {0, 0, -1, 1}; // 오른쪽, 아래
    static int[] dy = {1, -1, 0, 0};

    static Deque<Pair> q = new ArrayDeque<>();

    static boolean[][] visited;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        q.add(new Pair(0, 0));
        visited = new boolean[n][m];
        visited[0][0] = true;
        bfs();

        if(visited[n - 1][m - 1] == true) {
            System.out.println(1);
            System.exit(0);
        }

        System.out.println(0);
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
                    // 방문하지 않았고
                    // 뱀이존재하지 않고
                    // 그리드 범위 안이고
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    static boolean canGo(int nx, int ny) {
        // 방문하지 않았을 경우 && 뱀이존재하지 않아야함 && 그리드 범위 안
        if(!inRange(nx, ny)) return false;
        if(visited[nx][ny] == true || grid[nx][ny] == 0) { // 방문을 했거나 그리드에 뱀이 있거나
            return false;
        }
        return true;
    }

    static boolean inRange(int x, int y) {
        if((0 <= x && x < n) && (0 <= y && y <m)) return true;
        return false;
    }
}