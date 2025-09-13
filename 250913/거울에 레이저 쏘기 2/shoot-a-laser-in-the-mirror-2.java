import java.util.Scanner;

public class Main {

    static int[] dx = new int[]{0, 1, 0, -1}; // 우 하 좌 상
    static int[] dy = new int[]{1, 0, -1, 0};
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int k = sc.nextInt();

        // Please write your code here.
        int x = 0;
        int y = 0;
        int dir = 0;
        
        if(1 <= k && k <= n) {
            x = 0; y = k - 1; dir = 1;
        } else if(k <= 2 * n) {
            x = k - n - 1; y = n - 1; dir = 2;
        } else if(k <= 3 * n) {
            x = n - 1; y = 3*n - k; dir = 3;
        } else if(k <= 4 * n) {
            x = 4*n - k; y = 0; dir = 0;   
        }

        // System.out.println(startX + " " + startY);
        // System.out.println(curDirection);
        int steps = 0;
        // 사이클 가드(같은 칸, 같은 방향 재방문 시 무한반사)
        boolean[][][] visited = new boolean[n][n][4];

        // 반사 테이블(빠르고 깔끔)
        int[] slash = {3, 2, 1, 0}; // '/' 거울
        int[] back  = {1, 0, 3, 2}; // '\' 거울

        while (inRange(x, y)) {
            if (visited[x][y][dir]) { // 사이클이면 문제 요구에 맞춰 처리(여긴 -1 출력)
                System.out.println(-1);
                return;
            }
            visited[x][y][dir] = true;

            char c = grid[x][y];
            if (c == '/') dir = slash[dir];
            else if (c == '\\') dir = back[dir]; // 빈칸 없고 두 종류만 온다고 가정

            x += dx[dir];
            y += dy[dir];
            steps++;
        }

        System.out.println(steps);
        
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}