import java.util.Scanner;

// n x n 격자(0, 1로 구성)
// 1은 해당 위치에 폭탄이 놓임
// 1이 적힌 위치에 3가지 중 하나의 폭탄을 선택하여 초토화시킬 지역의 수를 최대화하고 싶다
// 가장 많이 초토화시킬 수 있는 영역의 수를 구하시오.

// 가능한 모든 순열을 만들어, 최대 영역을 구함. 각 폭탄마다 영향을 미치는 위치들을 나타내는 배열을 하나 만들면 코딩 실수를 줄일 수 있음.
// 폭탄이 m개라면 3^m개의 가능한 모든 순열을 만드는 재귀를 작성해볼 수 있다.
class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static final int BOMB_TYPE_NUM = 3;
    static final int MAX_N = 20;

    static int n;
    static int[][] bombType = new int[MAX_N][MAX_N];
    static boolean[][] bombed = new boolean[MAX_N][MAX_N];

    static int ans;
    static ArrayList<Pair> bombPos = new ArrayList<>();

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static void bomb(int x, int y, int bType) {
        Pair[][] bombShapes = {
            {},
            {new Pair(-2, 0), new Pair(-1, 0) , new Pair(0, 0), new Pair(1, 0), new Pair(2, 0)},
            {new Pair(-1, 0), new Pair(1, 0), new Pair(0, 0), new Pair(0, -1), new Pair(0, 1)},
            {new Pair(-1, -1), new Pair(-1, 1), new Pair(0, 0), new Pair(1, -1), new Pair(1, 1)}
        };

        for(int i = 0; i < 5; i++) {
            int dx = bombShapes[bType][i].x;
            int dy = bombShapes[bType][i].y;

            int nx = x + dx, ny = y + dy;
            if(inRange(nx, ny)) {
                bombed[nx][ny] = true;
            }
        }
    }

    static int calc() {
        // 폭탄이 터진 위치를 표시하는 배열을 초기화
        for(int i =  0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                bombed[i][j] = false;
            }
        }

        // 각 폭탄의 타입에 따라 초토화 되는 영역을 표시
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(bombType[i][j] > 0)
                    bomb(i, j, bombType[i][j]);
            }
        }

        // 초토화된 영역의수를 구함
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(bombed[i][j])
                    cnt++;
            }
        }

        return cnt;
    }

    static void findMaxArea(int cnt) {
        if(cnt == bombPos.size()) {
            ans = Math.max(ans, calc());
            return;
        }

        for(int i = 1; i <= 3; i++) {
            int x = bombPos.get(cnt).x;
            int y = bombPos.get(cnt).y;

            bombType[x][y] = i;
            findMaxArea(cnt + 1);
            bombType[x][y] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int bombPlace = sc.nextInt();
                if(bombPlace > 0)
                    bombPos.add(new Pair(i, j));
            }
        }

        findMaxArea(0);

        System.out.println(ans);
    }

    
}