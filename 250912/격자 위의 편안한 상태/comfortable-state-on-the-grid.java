import java.util.Scanner;
// '편안한 상태' = 위아래양옆 인접한 4칸에 색칠되어 있는 칸이 정확히 3개인 경우
// 색칠할 칸이 칠한 직후 편안한 상태인지 체크하는 프로그램
public class Main {

    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};

    static int[][] graph;
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.

        graph = new int[n][n];
        for(int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            graph[r][c] = 1;

            if(comfortableStatus(r, c)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    static boolean comfortableStatus(int r, int c) {
        int cnt = 0;
        int curX = 0;
        int curY = 0;
        for(int i = 0; i < 4; i++) {
            curX = r + dx[i];
            curY = c + dy[i];

            if(inRange(curX, curY) && graph[curX][curY] == 1) {
                cnt += 1;
            }
        }

        if(cnt == 3) {
            return true;
        } else {
            return false;
        }
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}