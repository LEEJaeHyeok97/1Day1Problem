import java.util.Scanner;
public class Main {
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int cnt = 0;
                for(int di = 0; di < 4; di++) {
                    int nx = i + dx[di];
                    int ny = j + dy[di];

                    if (inRange(nx, ny) && arr[nx][ny] == 1) {
                        cnt +=1;
                    }
                }

                if(cnt >= 3) {
                    ans +=1;
                }
            }
        }

        System.out.println(ans);
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}