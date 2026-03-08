import java.util.*;

// 각 칸이 1이상 100이하 정수 n x n 그리드
// 만약 아직 K번을 반복하지 못했지만, 더 이상 새로 이동할 위치가 없다면 움직이는 것 종료
// 기본적으로는 K번 반복한 이후 위치를 구함
// 이동 조건
// 1. 시작 위치에 적혀 있는 숫자 x보다 작은 곳으로는 (인접칸) 전부 이동 가능
// 2. 1번 조건을 만족하여 도달할 수 있는 칸들 숫자 중 최댓값으로 이동 고려
// 3. 2번 조건을 만족하는 숫자가 여러개 일 경우, 행 번호가 가장 작은곳으로 이동.
// 4. 행 번호도 같은 숫자가 여러개 일 경우, 열 번호가 가장 작은 곳으로 이동.
// 이렇게 이동을 K번 반복한 후의 위치를 구하는 프로그램.
// 아직 K번 반복하지 못했더라도, 더 이상 새로 이동할 위치가 없다면 종료.
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
public class Main {

    static int n, k;
    static int[][] grid;
    static int r, c;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static boolean[][] visited;
    static boolean[][] tmpVisited;

    static ArrayList<Pair> candidate = new ArrayList<>();

    static Deque<Pair> q = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        visited = new boolean[n][n];
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        r = sc.nextInt() - 1; // 시작 위치 r, c
        c = sc.nextInt() - 1;
    
        
        while(k-- > 0) {
            // System.out.println("=====");
            // System.out.println(r + " " + c);
            visited[r][c] = true;
            q.add(new Pair(r, c));
            bfs();
            resetVisited();
            candidate = new ArrayList<>();
        }

        r++;
        c++;
        System.out.println(r + " " + c);
    }

    static void bfs() {
        int maxValue = maxValueBfs();
        // System.out.println("maxValue = " + maxValue);

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
                    if(grid[nx][ny] == maxValue) candidate.add(new Pair(nx, ny));
                }
            }
        }
        
        if(candidate.size() == 0) return;

        // 행이 작고 행이 같다면 열이 작은 값을 선택해야한다.
        candidate.sort(Comparator.comparingInt(Pair::getX).thenComparing(Pair::getY));
        for(int i = 0; i < candidate.size(); i++) {
            Pair candi = candidate.get(i);
            // System.out.println("후보: " + candi.x + " " + candi.y);
        }
        Pair p = candidate.get(0);
        // 현재 r, c를 교체해야 함.
        r = p.x;
        c = p.y;
    }

    static int maxValueBfs() {
        int value = Integer.MIN_VALUE;
        Deque<Pair> tmp = new ArrayDeque<>();
        tmpVisited = new boolean[n][n];
        tmp.add(new Pair(r, c));
        while(!tmp.isEmpty()) {
            Pair p = tmp.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo2(nx, ny) && tmpVisited[nx][ny] == false) {
                    value = Math.max(value, grid[nx][ny]);
                    tmp.add(new Pair(nx, ny));
                    tmpVisited[nx][ny] = true;
                }
            }
        }
        
        return value;
    }

    static boolean canGo(int x, int y) {
        if(!inRange(x, y)) return false;
        if(grid[x][y] >= grid[r][c]) return false;
        if(visited[x][y] == true) return false;
        return true;
    }

    static boolean canGo2(int x, int y) {
        if(!inRange(x, y)) return false;
        if(grid[x][y] >= grid[r][c]) return false;
        if(tmpVisited[x][y] == true) return false;
        return true;
    }

    static boolean inRange(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y <n);
    }

    static void resetVisited() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }
}