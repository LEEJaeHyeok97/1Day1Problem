import java.util.Scanner;
public class Main {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    static int n, m;
    static char[][] arr;
    static char[] alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.

        int idx = 0;
        arr = new char[n][m];
        int d = 0;
        int x = 0, y = 0;
        arr[0][0] = 'A';
        for(int i = 1; i < n*m; i++) {
            int curX = x + dx[d];
            int curY = y + dy[d];
            if(!inRange(curX, curY) || arr[curX][curY] != '\0') {
                d = (d + 1) % 4;
                x += dx[d];
                y += dy[d];
            }
            else {
                x = curX;
                y = curY;
            }

            idx = (idx + 1) % 26;
            arr[x][y] = alphabet[idx];
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}