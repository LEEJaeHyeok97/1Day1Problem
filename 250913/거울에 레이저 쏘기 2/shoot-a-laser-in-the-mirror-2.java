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
        int startNum = sc.nextInt();
        int curDirection = (startNum - 1) / n;
        // Please write your code here.
        int curX = 0;
        int curY = 0;
        int time = 1;
        int d = 0;
        int startX = 0;
        int startY = 0;
        for(int i = 1; i <= n * 4; i++) {
            if(!inRange(curX, curY)) {
                d +=1;
                continue;
            } else {
                curX += curX + dx[d];
                curY += curY + dy[d];
            }

            if(time == (startNum - 1)) {
                startX = curX;
                startY = curY;
                break;
            }
            time++;
        }

        // System.out.println(startX + " " + startY);
        // System.out.println(curDirection);

        int ans = 0;
        while(true) {
            if(!inRange(startX, startY)) {
                System.out.println(ans);
                return;
            }

            if(grid[startX][startY] == '/') {// 우 하 좌 상
                if(curDirection == 0) {
                    d = 3;
                } else if(curDirection == 1) {
                    d = 2;
                } else if(curDirection == 2) {
                    d = 1;
                } else if(curDirection == 3) {
                    d = 0;
                }
            } else { // '\'
                if(curDirection == 0) {
                    d = 1;
                } else if(curDirection == 1) {
                    d = 0;
                } else if(curDirection == 2) {
                    d = 3;
                } else if(curDirection == 3) {
                    d = 2;
                }
            }
            startX += dx[d];
            startY += dy[d];
            ans+=1;
        }
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}