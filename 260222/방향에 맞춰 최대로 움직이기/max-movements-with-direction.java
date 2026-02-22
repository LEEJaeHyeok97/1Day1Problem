import java.util.*;

// n*n 그리드. 각 칸이 1이상
// 수는 중복없이단 한 번씩만 주어지며, 방향은 8방향중 하나
// 특정 위치에서 시작하여 현재 위치에 적혀있는 방향에 있는 수들 중 현재 수보다 더 큰 수가
// 적혀 있는 곳으로 이동하는 것을 최대한 많이 반복
// 시작 위치로부터 조건을 만족하며(적힌 수 보다 더 커야) 최대 몇 번 이동할 수 있는지
// 시작 워치는 r, c;
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int r, c;
    static int dir;
    static int n;
    static int ans;

    static ArrayList<Pair> arr = new ArrayList<>();

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static int[][] num;
    static int[][] moveDir;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        // n개의 줄에 걸쳐 각 칸에 숫자가 주어짐
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }

        // n개의 줄에 걸쳐 각 칸에 방향을 나타내는 숫자가 주어짐
        moveDir = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moveDir[i][j] = sc.nextInt() - 1;
            }
        }
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;
        
        ans = 0;
        dir = moveDir[r][c];

        arr.add(new Pair(r, c));
        backtracking(1);

        System.out.println(ans);
    }

    static void backtracking(int cnt) {
        if(!hasValidPos()) {
            ans = Math.max(ans, arr.size());
            // System.out.println(r + " " + c);
            return;
        }

        
        for(int i = 0; i < n; i++) {
            int nx = r + dx[dir] * i;
            int ny = c + dy[dir] * i;

            if(inRange(nx, ny) && isValidPos(nx, ny)) {
                arr.add(new Pair(nx, ny));
                dir = moveDir[nx][ny];
                r = nx; c = ny;

                backtracking(cnt + 1);

                arr.remove(arr.size() - 1);
                Pair pair = arr.get(arr.size() - 1);
                dir = moveDir[pair.x][pair.y];
                r = pair.x; c = pair.y;
            }
        }
    }

    static boolean hasValidPos() {// 갈 수 있는 위치가 하나라도 존재하는지 확인
        for(int i = 1; i < n; i++) {
            int nx = r + dx[dir];
            int ny = c + dy[dir];

            if(inRange(nx, ny)) {
                if(num[nx][ny] > num[r][c])
                    return true;
            } 
        }

        return false;
    }

    static boolean isValidPos(int x, int y) { 
        if(num[r][c] < num[x][y]) return true;
        return false;
    }

    static boolean inRange(int x, int y) {
        if ((0 <= x && x < n) && (0 <= y && y < n)) return true;
        return false;
    }
}