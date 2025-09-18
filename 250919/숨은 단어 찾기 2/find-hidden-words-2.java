import java.util.Scanner;
public class Main {
    static int[] dx = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        // Please write your code here.
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < m; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 'L') {
                    for(int d = 0; d < 8; d++) {
                    int nx = i; int ny = j; char[] tmp = new char[3];
                    tmp[0] = arr[nx][ny];
                    for(int t = 1; t < 3; t++) {
                        nx += dx[d]; ny += dy[d];
                        if(inRange(nx, ny)) {
                            tmp[t] = arr[nx][ny];
                        }
                        else break;
                    }

                    if(tmp[0] == 'L' && tmp[1] == 'E' && tmp[2] == 'E'){
                        // System.out.println(i + " " + j);
                        ans++;

                    }
                }
                }
            }
        }
        System.out.println(ans);
        
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}