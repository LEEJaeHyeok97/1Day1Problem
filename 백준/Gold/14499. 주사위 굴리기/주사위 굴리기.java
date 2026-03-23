import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n*m .
// 이동한 칸에 있는 수가 0이면, 주사위 바닥면에 쓰여 있는 수가 복사. 그 반대면 반대로 복사
// 주사위는 지도의 바깥으로 이동시킬 수 없다. 만약 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.
// 처음에 주사위의 모든 면은 0.
public class Main {

    static int n, m, k;
    static int[][] grid;
    static int curX, curY;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};


    static int[] dice = {0, 0, 0, 0, 0, 0}; // 현재 바닥면, 왼쪽, 오른쪽, 앞, 뒤, 위

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // n, m, 좌표x, 좌표y, 명령의 개수 k
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        curX = Integer.parseInt(st.nextToken());
        curY = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 지도 정보가 주어짐. 주사위를 놓은 칸은 항상 0
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int number = Integer.parseInt(st.nextToken());
                grid[i][j] = number;
            }
        }

        // 이동하는 명령이 주어짐.(동: 1, 서: 2, 북: 3, 남: 4)
//        move = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int move = Integer.parseInt(st.nextToken());
            int nx = 0, ny = 0;
            if (move == 1) {
                nx = curX + dx[1];
                ny = curY + dy[1];
                if (!inRange(nx, ny)) {
                    continue;
                }

                // 동쪽으로 이동.
                // 아래값이 왼쪽 값으로 이동
                // 오른쪽 값이 아래값으로 이동
                // 왼쪽값이 위로 이동
                // 위 값이 오른쪽 값으로 이동
                //static int[] dice = {0, 0, 0, 0, 0, 0}; // 현재 바닥면, 왼쪽, 오른쪽, 앞, 뒤, 위
                int[] tmpDice = new int[6];
                tmpDice[0] = dice[2]; // 오른쪽 값이 아래값으로 이동
                tmpDice[1] = dice[0]; // 아래값이 왼쪽 값으로 이동
                tmpDice[5] = dice[1];// 왼쪽값이 위로 이동
                tmpDice[2] = dice[5];// 위 값이 오른쪽 값으로 이동
                tmpDice[3] = dice[3];
                tmpDice[4] = dice[4];

                dice = tmpDice;
                curX = nx;
                curY = ny;
            }
            if (move == 2) {
                nx = curX + dx[0];
                ny = curY + dy[0];

                if (!inRange(nx, ny)) {
                    continue;
                }
                // 서쪽으로 이동
                // 바닥면이 오른쪽으로 이동
                // 오른쪽값이 위로 이동
                // 위값이 왼쪽으로 이동
                // 왼쪽값이 바닥으로 이동
                //static int[] dice = {0, 0, 0, 0, 0, 0}; // 현재 바닥면, 왼쪽, 오른쪽, 앞, 뒤, 위
                int[] tmpDice = new int[6];
                tmpDice[2] = dice[0]; // 바닥면이 오른쪽으로 이동
                tmpDice[5] = dice[2]; // 오른쪽값이 위로 이동
                tmpDice[1] = dice[5]; // 위값이 왼쪽으로 이동
                tmpDice[0] = dice[1]; // 왼쪽값이 바닥으로 이동
                tmpDice[3] = dice[3];
                tmpDice[4] = dice[4];

                dice = tmpDice;
                curX = nx;
                curY = ny;
            }
            if (move == 3) {
                nx = curX + dx[2];
                ny = curY + dy[2];

                if (!inRange(nx, ny)) {
                    continue;
                }
                // 북쪽으로 이동
                // 바닥면이 뒤쪽으로 이동
                // 뒤쪽값이 위로 이동
                // 위값이 앞으로 이동
                // 앞 값이 바닥으로 이동
                //static int[] dice = {0, 0, 0, 0, 0, 0}; // 현재 바닥면, 왼쪽, 오른쪽, 앞, 뒤, 위
                int[] tmpDice = new int[6];
                tmpDice[4] = dice[0]; // 바닥면이 뒤쪽으로 이동
                tmpDice[5] = dice[4]; // 뒤쪽값이 위로 이동
                tmpDice[3] = dice[5]; // 위값이 앞으로 이동
                tmpDice[0] = dice[3]; // 앞 값이 바닥으로 이동
                tmpDice[1] = dice[1];
                tmpDice[2] = dice[2];

                dice = tmpDice;
                curX = nx;
                curY = ny;
            }
            if (move == 4) {
//                System.out.println("tttttt");
                nx = curX + dx[3];
                ny = curY + dy[3];
                if (!inRange(nx, ny)) {
                    continue;
                }
//                System.out.println(nx + " " + ny + "hmmmmm");

                // 남쪽으로 이동
                // 바닥면이 앞으로 이동
                // 앞 값이 위로 이동
                // 위 값이 뒤로 이동
                // 뒤 값이 바닥을로 이동
                //static int[] dice = {0, 0, 0, 0, 0, 0}; // 현재 바닥면, 왼쪽, 오른쪽, 앞, 뒤, 위
                int[] tmpDice = new int[6];
                tmpDice[3] = dice[0]; // 바닥면이 앞으로 이동
                tmpDice[5] = dice[3]; // 앞 값이 위로 이동
                tmpDice[4] = dice[5]; // 위 값이 뒤로 이동
                tmpDice[0] = dice[4]; // 뒤 값이 바닥을로 이동
                tmpDice[1] = dice[1];
                tmpDice[2] = dice[2];

                dice = tmpDice;
                curX = nx;
                curY = ny;
            }

//            System.out.println("hello");
//            System.out.println(nx + " " + ny);

//                System.out.println("hello");
            // 현재 값 업데이트(curX, curY)
//            curX = nx;
//            curY = ny;

//            System.out.println(dice[5]);

//            System.out.println(nx + " " + ny);
//            System.out.println(dice[5]);
            if (!inRange(nx, ny)) {
                continue;
            } else {
//                System.out.println(dice[5]);
                // 그리드에 적혀 있는 수가 0이 아니면 주사위에 옮겨적기. 칸에 있는 수는 0이 된다.
                if (grid[nx][ny] != 0) {
                    dice[0] = grid[nx][ny];
                    grid[nx][ny] = 0;
                } else {
                    // 그리드에 적혀 있는 수가 0이면 주사위 바닥면에 있는 수가 칸에 복사된다.
                    grid[nx][ny] = dice[0];
                }
                curX = nx;
                curY = ny;
                System.out.println(dice[5]);
            }

        }
    }

    static boolean inRange(int x, int y) {
        return (0 <= x && x < n) && (0 <= y && y < m);
    }
}
