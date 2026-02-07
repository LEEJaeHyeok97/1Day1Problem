import java.util.Scanner;

// 주사위를 격자 위 특정 위치에 올려두고
// M번에 걸쳐 상하좌우 중 한 방향으로 딱 한 칸을 이동하도록 굴리기를 반복
// 각 주사위가 격자판에 닿을때마다 격자판에는 해당 위치에 주사위 아랫면에 적혀있던 숫자가 적힌다.
// 이미 해당 위치에 숫자가 적혀있었더라도, 새로 숫자가 적히게 된다.
// 격자 크기 N, 주사위 굴릴 횟수 M, 초기 주사위 위치 r, c
// 주사위를 모두 굴린 이후 격자판에 적혀 있는 숫자의 총 합 출력
// 주사위를 굴렸을 때 격자 밖으로 나가게 되는 경우는 주사위를 굴리지 않고 다음 과정 수행
// 처음 주사위가 놓여져 있는 방향은 위가 1 오른쪽이 3 아래가 2 (양쪽 합이 7)
public class Main {
    
    static int n, m, r, c;
    static int cur = 1, curRight = 3, curDown = 2;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        grid = new int[n][n];
        String[] directions = new String[m];
        for (int i = 0; i < m; i++) {
            directions[i] = sc.next();
        }
        // Please write your code here.
        int[] dx = {0, 0, -1, 1}; // 좌, 우, 상, 하
        int[] dy = {-1, 1, 0, 0};
        int nx, ny;
        grid[r][c] = 7 - cur;
        for(int i = 0; i < directions.length; i++) {
            String dir = directions[i];
            if(dir.equals("L")) {
                nx = r + dx[0];
                ny = c + dy[0];

                if(inRange(nx, ny)) {
                    roll(dir);
                    r = nx;
                    c = ny;
                    grid[r][c] = 7 - cur;
                }
            }
            if(dir.equals("R")) {
                nx = r + dx[1];
                ny = c + dy[1];

                if(inRange(nx, ny)) {
                    roll(dir);
                    r = nx;
                    c = ny;
                    grid[r][c] = 7 - cur;
                }
            }
            if(dir.equals("U")) {
                nx = r + dx[2];
                ny = c + dy[2];

                if(inRange(nx, ny)) {
                    roll(dir);
                    r = nx;
                    c = ny;
                    grid[r][c] = 7 - cur;
                }
            }
            if(dir.equals("D")) {
                nx = r + dx[3];
                ny = c + dy[3];

                if(inRange(nx, ny)) {
                    roll(dir);
                    r = nx;
                    c = ny;
                    grid[r][c] = 7 - cur;
                }
            }
        }

        int ans = calculateSum();
        System.out.println(ans);
    }

    static void roll(String dir) {
        int tmp;
        if(dir.equals("L")) {
            tmp =  7- cur;
            cur = curRight;
            curRight= tmp;
        }
        if(dir.equals("R")) {
            tmp = 7 - curRight;
            curRight = cur;
            cur = tmp;
        }
        if(dir.equals("D")) {
            tmp = 7 - curDown;
            curDown = cur;
            cur = tmp;
        }
        if(dir.equals("U")) {
            tmp = curDown;
            curDown = 7 - cur;
            cur = tmp;
        }
    }

    static boolean inRange(int r, int c) {
        if((0 <= r && r < n) && (0 <= c && c < n)) return true;
        return false;
    }

    static int calculateSum() {
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    ans += grid[i][j];
                }
            }
        }

        return ans;
    }
}