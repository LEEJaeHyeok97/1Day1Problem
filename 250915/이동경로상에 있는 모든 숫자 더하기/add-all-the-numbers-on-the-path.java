import java.util.Scanner;

public class Main {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int t = sc.nextInt();
        String commands = sc.next();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int curX; int curY;
        if(n == 1) {
            curX = 0; curY = 0;
        } else {
            curX = n / 2; curY = n / 2;
        }

        int curD = 0;
        int ans = board[curX][curY];
        for(int i = 0; i < commands.length(); i++) {
            char c = commands.charAt(i);
            if(c == 'F') {
                int nx = curX + dx[curD]; int ny = curY + dy[curD];
                if(inRange(nx, ny)) {
                    ans += board[nx][ny];
                    curX = nx; curY = ny;
                }
            } else if(c == 'R') {
                curD = (curD + 1) % 4;
            } else if(c == 'L') {
                curD = (curD + 3) % 4;
            }
        }

        System.out.println(ans);
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}