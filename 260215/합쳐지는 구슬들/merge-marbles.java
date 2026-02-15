import java.util.*;

// n *n 격자 m개의 구슬.
// 1초에 한 칸 움직임.
// 구슬이 벽에 부딪힐 시 방향을 바꿈 방향 바꾸는데 1초 소요
// 구슬끼리 1초 후 한 위치로 오게될 시 구슬들은 전부 합쳐지게된다.
// 무게는 구슬들의 합으로 결정, 방향은 구슬들 중 가장 큰 번호가 매겨진 구슬의 방향을 따른다
// , 번호는 마찬가지로 구슬들 중 가장 큰 번호를 갖게 된다.
// T초 후 여전히 격자에 남아있는 구슬의 개수와 가장 무거운 구슬의 무게를 출력
class Marble {
    int num;
    int w;
    char d;
    
    public Marble(int num, int w, char d) {
        this.num = num;
        this.w = w;
        this.d = d;
    }
}
public class Main {

    static int n, m, t;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Marble>[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        grid = new ArrayList[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            char d = sc.next().charAt(0);
            int w = sc.nextInt();

            grid[r][c].add(new Marble(i, w, d));
        }
        
        // t초 동안 시뮬레이션
        for(int ts = 0; ts < t; ts++) {
            ArrayList<Marble>[][] tmpGrid = new ArrayList[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    tmpGrid[i][j] = new ArrayList<>();
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    ArrayList<Marble> tmp = grid[i][j];
                    if(tmp.size() > 0) {
                        Marble marble = tmp.get(0);
                        int dir = dirMapInt(marble.d);

                        int nx = i + dx[dir];
                        int ny = j + dy[dir];

                        if(inRange(nx, ny)) {
                            tmpGrid[nx][ny].add(new Marble(marble.num, marble.w, marble.d));
                        } else {
                            tmpGrid[i][j].add(new Marble(marble.num, marble.w, changeDir(marble.d)));
                        }
                    }
                }
            }

            grid = tmpGrid;

            // 같은 공간에 2개 이상이 있을 경우 crash 처리
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j].size() > 1) {
                        crash(grid[i][j]);
                    }
                }
            }
        }

        // T초 후 여전히 격자에 남아있는 구슬의 개수와 가장 무거운 구슬의 무게를 출력
        int restCnt = 0;
        int maxWeight = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j].size() > 0) {
                    restCnt++;
                    maxWeight = Math.max(maxWeight, grid[i][j].get(0).w);
                }
            }
        }

        System.out.print(restCnt + " ");
        System.out.println(maxWeight);
    }

    static void crash(ArrayList<Marble> marbles) {
        int totalWeight = 0;
        int maxNum = -1;
        char d = 'a';

        for(int i = 0; i < marbles.size(); i++) {
            totalWeight += marbles.get(i).w;
            maxNum = Math.max(maxNum, marbles.get(i).num);
        }

        for(int i = 0; i < marbles.size(); i++) {
            if(marbles.get(i).num == maxNum) {
                d = marbles.get(i).d;
            }
        }

        Marble tmp;
        tmp = new Marble(maxNum, totalWeight, d);
        marbles.clear();
        marbles.add(tmp);
    }

    static int dirMapInt(char dir) {
        if(dir == 'U') return 0;
        if(dir == 'D') return 1;
        if(dir == 'L') return 2;
        return 3;
    }

    static boolean inRange(int x, int y) {
        if((0 <= x && x < n) && (0 <= y && y < n)) return true;
        return false;
    }

    static char changeDir(char dir) {
        if(dir == 'U') return 'D';
        if(dir == 'D') return 'U';
        if(dir == 'L') return 'R';
        return 'L';
    }
}