import java.util.*;

// N X N 격자 사과들의 위치, 뱀의 움직임이 주어짐
// 게임이 끝나는데 몇 초가 걸리는지 출력
// 뱀은 처음 좌측 상단에 (1,1) 길이 1로 있음.
// 사과를 먹으면 길이가 1늘어남(꼬리 삭제 x)
// 게임은 뱀이 전부 움직였거나, 격자를 벗어나거나, 몸이꼬여 서로 겹쳐졌을 경우 종료
// 양의 정수 N(그리드 한 변의 길이), 사과의 개수 M, 뱀의 방향 변환 횟수 K
// 2번째 줄 부터 M개 줄까지 사과의 위치가 주어짐
// 그 다음 K개의 줄에 걸쳐 뱀의 방향 변환 정보가 주어짐 d: U, D, R, L 중 하나. p는 얼마나 움직일지 
class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int n, m, k;
    static int curX, curY;
    static int[][] grid;
    static int[] dx = {0, 0, -1, 1}; // 좌, 우, 상, 하
    static int[] dy = {-1, 1, 0, 0};
    static Deque<Point> q = new ArrayDeque<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        
        grid = new int[n][n];
        curX = 0;
        curY = 0;
        grid[curX][curY] = 2; // 뱀의 존재 여부
        q.add(new Point(curX, curY));
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            grid[x][y] = 1; // 사과 표기
        }

        int time = 0;
        for (int i = 0; i < k; i++) {
            char d = sc.next().charAt(0);
            int p = sc.nextInt();
            
            for(int j = 0; j < p; j++) {
                int nx = -1;
                int ny  = -1;
                if(d == 'U') {
                    nx = curX + dx[2];
                    ny = curY + dy[2];             
                }
                if(d == 'D') {
                    nx = curX + dx[3];
                    ny = curY + dy[3];
                }
                if(d == 'R') {
                    nx = curX + dx[1];
                    ny = curY + dy[1];
                }
                if(d == 'L') {
                    nx = curX + dx[0];
                    ny = curY + dy[0];
                }

                if(inRange(nx, ny)) {
                        if(grid[nx][ny] == 1) { // 사과가 존재
                            q.add(new Point(nx, ny));
                        }
                        else { //사과가 없을 때
                            Point point = q.poll();
                            grid[point.x][point.y] = 0;
                            q.add(new Point(nx, ny));
                        }
                }
                else { // 경계를 넘어서는 경우
                    System.out.println(++time);
                    return;
                }

                if(grid[nx][ny] == 2) { // 몸이 겹쳐지는 경우 종료
                    System.out.println(++time);
                    return;
                }
                grid[nx][ny] = 2;
                curX = nx;
                curY = ny;
                time++;

                // for(int i2 = 0; i2 < n; i2++) {
                //     for(int j2 = 0; j2 < n; j2++) {
                //         System.out.print(grid[i2][j2] + " ");
                //     }

                //     System.out.println();
                // }
                // System.out.println("=========");
            }
        }

        System.out.println(time);
    }

    static boolean inRange(int x, int y) {
        if((0 <= x && x < n) && (0 <= y && y < n)) return true;
        return false;
    }
}