import java.util.*;

// n x m 크기의 격자 마을
// 각 집의 높이는 1이상 100이하의 숫자
// 비가 K(K>=1)만큼 온다고 한다면, 마을에 있는 집들 중 높이가 K 이하인 집들은 전부 물에 잠김
// 대책을 세우기 위해 미리 각 K에 따라 안전 영역의 개수가 어떻게 달라지는지를 보려고 합니다.
// 잠기지 않은 집들끼리 서로 인접해 있는 경우동일한 안전 영역에 있는 것으로 본다.
// 안전 영역의 수가 최대가 될 때의 K와 그때의 안전 영역의 수를 구해주는 프로그램을 작성.
// K가 여러개라며 가장 작은 K와 그 때의 안전 영역의 수를 출력.
class Pair {
    int k;
    int cnt;

    public Pair(int k, int cnt) {
        this.k = k;
        this.cnt = cnt;
    }

    public int getK() { return k; }
    public int getCnt() { return cnt; }
}

public class Main {

    static int n, m;
    static int curK = 1;
    static int[][] grid;
    static boolean[][] visited;
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static ArrayList<Pair> arr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        visited = new boolean[n][m];
        for(int k = 1; k <= 100; k++) {
            resetVisited();
            curK = k;
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(!visited[i][j] && grid[i][j] > curK) {
                        visited[i][j] = true;
                        cnt += 1;
                        dfs(i, j);
                    }
                }
            }

            arr.add(new Pair(k, cnt));
        }

        arr.sort(Comparator.comparing(Pair::getCnt, Comparator.reverseOrder())
                        .thenComparing(Pair::getK));

        Pair p = arr.get(0);
        System.out.println(p.k + " " + p.cnt);
    }

    static void dfs(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(canGo(nx, ny)) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }

    static boolean canGo(int x, int y) {
        if(inRange(x, y) && grid[x][y] > curK && visited[x][y] == false) {
            return true;
        }

        return false;
    }

    static boolean inRange(int x, int y) {
        if((0 <= x && x < n) && (0 <= y && y < m)) return true;
        return false;
    }

    static void resetVisited() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
    }
}