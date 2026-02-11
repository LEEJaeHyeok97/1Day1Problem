import java.util.*;

// n * n 격자, m개의 구슬
// 구슬은 1초에 한 칸씩 동일한 속도로 움직인다.
// 구슬이 벽에 부딪히면 움직이지 않고 움직이는 방향만 반대로 뒤집힌다.(방향 전환 =1초)
// 2개 이상의 구슬이 충돌 시 부딪힌 구슬 모두 사라짐
// 같은 위치가 아닌 이동 중인 경우 충돌이 일어나지 않는다.
// 테스트 케이스 t
// 구슬 정보 행 x, 열 y, 방향 d(u, d, r, l)
// n, m (격자 한 변 길이, 구슬 수)
// 해당 테스트 케이스에 남아있는 구슬의 수를 출력
class Point {
    int x;
    int y;
    char d;

    public Point(int x, int y, char d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setReverseDir(char d) {
        if(d == 'U') this.d = 'D';
        if(d == 'D') this.d = 'U';
        if(d == 'L') this.d = 'R';
        if(d == 'R') this.d = 'L';
    }
}
public class Main {
    
    static int N, M, T;
    static int[][] grid;
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            N = sc.nextInt();
            M = sc.nextInt();
            ArrayList<Point> arr = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                char d = sc.next().charAt(0);

                arr.add(new Point(x, y, d));
            }

            for(int rep = 0; rep < 90; rep++) {
                grid = new int[N][N];
                for(int k = 0; k < arr.size(); k++) {
                    Point p = arr.get(k);

                    int nx = p.x;
                    int ny = p.y;
                    char d = p.d;

                    if(d == 'U') {
                        nx += dx[0];
                        ny += dy[0];
                    }
                    if(d == 'D') {
                        nx += dx[1];
                        ny += dy[1];
                    }
                    if(d == 'L') {
                        nx += dx[2];
                        ny += dy[2];
                    }
                    if(d == 'R') {
                        nx += dx[3];
                        ny += dy[3];
                    }

                    if(inRange(nx, ny)) {
                        p.setXY(nx, ny);
                        grid[nx][ny] += 1;
                    }
                    else { // 방향 전환
                        p.setReverseDir(d);
                        grid[p.x][p.y]++;
                    }
                }

                // 위치가 겹치는 구슬들 삭제 작업
                ArrayList<Point> tmpArr = new ArrayList<>();
                for(int i = 0; i < arr.size(); i++) {
                    Point p = arr.get(i);

                    if(grid[p.x][p.y] == 1) {
                        tmpArr.add(p);
                    }
                }

                arr = tmpArr;
            }

            System.out.println(arr.size());
        }
    }

    static boolean inRange(int x, int y) {
        if((0<=x && x <N) && (0<=y && y < N)) return true;
        return false;
    }
}