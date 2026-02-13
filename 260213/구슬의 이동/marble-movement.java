import java.util.*;

// N X N 격자. 각 구슬 M개가 일정 속도를 갖고 정해진 방향으로 움직임
// 구슬이 벽에 부딪히면 움직이는 방향이 반대로 뒤집혀 동일한 속도로 움직이는 것을 반복
// 방향으 바꾸는 데에는 시간이 전혀 소요되지 않는다.
// 동일한 위치에 구슬이 K개 이하라면 문제 없이 진행
// 만약 K개가 넘는 구슬이 같은 칸에 위치하게 된다면, 우선순위가 높은 구슬 K개만 살아남음
// 구슬의 속도가 빠를수록 => 우선순위가 높음
// 구슬의 속도가 일치할 시 구슬의번호가 더 큰 구슬이 우선순위가 높음
// 정수시간만큼 지난 경우에만 충돌을 따진다.
// T초가 지난 후에도 여전히 격자 안에 남아 있는 구슬의 개수를 출력
class Bead {
    int number;
    char d;
    int v;

    public Bead(int number, char d, int v) {
        this.number = number;
        this.d = d;
        this.v = v;
    }
}

public class Main {

    static ArrayList<Bead>[][] grid;
    static int[] dx = {0, 0, -1, 1}; // 좌 우 상 하
    static int[] dy = {-1, 1, 0, 0};
    static int n, m, t, k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 격자의 크기
        m = sc.nextInt(); // 구슬의 개수
        t = sc.nextInt(); // 시간
        k = sc.nextInt(); // 각 칸에 살아남을 수 있는 최대 구슬 수

        grid = new ArrayList[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1; // 구슬 행
            int c = sc.nextInt() - 1; // 구슬 열
            char d = sc.next().charAt(0); // 방향
            int v = sc.nextInt(); // 속도
            grid[r][c].add(new Bead(i, d, v));
        }

        for(int ti = 0; ti < t; ti++) {

            ArrayList<Bead>[][] tmpGrid = new ArrayList[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    tmpGrid[i][j] = new ArrayList<>();
                }
            }
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    ArrayList<Bead> tmp = grid[i][j];
                    if(grid[i][j].size() > 0) {
                        for(int s = 0; s < tmp.size(); s++) {
                            Bead bead = tmp.get(s);
                            int nx = i;
                            int ny = j;
                            char dir = bead.d;
                            for(int a = 0; a < bead.v; a++) {
                                int dirNum = getDirNum(dir);
                                int tx = nx + dx[dirNum];
                                int ty = ny + dy[dirNum];

                                if(!inRange(tx, ty)) {
                                    dir = changeDir(dir);
                                    dirNum = getDirNum(dir);
                                    tx = nx + dx[dirNum];
                                    ty = ny + dy[dirNum];
                                }

                                nx = tx;
                                ny = ty;
                            }

                            tmpGrid[nx][ny].add(new Bead(bead.number, dir, bead.v));
                        }
                    }
                }
            }

            // 한 칸에 k 초과인 구슬 crash처리
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(tmpGrid[i][j].size() > k) {
                        crash(i, j, tmpGrid);
                    }
                }
            }

            grid = tmpGrid;
        }

        System.out.println(calculateBeads());
    }

    static void crash(int x, int y, ArrayList<Bead>[][] tmpGrid) {
        //tmpGrid 사용
        ArrayList<Bead> tmp = tmpGrid[x][y];
        int delCnt = tmp.size() - k;
        int cnt = 0;
        tmp.sort(Comparator.comparingInt((Bead b) -> b.v).thenComparingInt(b -> b.number));
        while(cnt != delCnt) {
            tmp.remove(0);
            cnt++;
        }

        tmpGrid[x][y] = tmp;
    }

    static int calculateBeads() {
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j].size() > 0) ans += grid[i][j].size();
            }
        }

        return ans;
    }

    static boolean inRange(int x, int y) {
        if((0 <= x && x < n) && (0 <= y && y < n)) return true;
        return false;
    }

    static char changeDir(char dir) {
        if(dir == 'U') {
            return 'D';
        }
        if(dir == 'D') {
            return 'U';
        }
        if(dir == 'L') {
            return 'R';
        }
        return 'L';
    }

    static int getDirNum(char dir) {
        if(dir == 'U') {
            return 2;
        }
        if(dir == 'D') {
            return 3;
        }
        if(dir == 'L') {
            return 0;
        }
        return 1;
    }
}