import java.util.Scanner;

public class Main {
    static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                if(arr[i][j] != 0) {
                    for(int k = 0; k < 8; k++) {
                        int nx = i; int ny = j; int cnt = 1;
                        for(int t = 0; t < 5; t++) {
                            nx += dx[k]; ny += dy[k];
                            if(inRange(nx, ny)) {
                                if(arr[nx][ny] == arr[i][j]) {
                                    cnt++;
                                }
                            }
                        }
                        // System.out.println(cnt);
                        if(cnt == 5) {
                            // System.out.println(i + " " + j);
                            System.out.println(arr[i + 1][j + 1]);
                            System.out.println((i+2 + 2*dx[k]) + " " + (j + 2*dy[k] + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < 19 && 0 <= y && y < 19;
    }
}