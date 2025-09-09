import java.util.Scanner;

public class Main {
    static int N;

    static int[] dx = new int[]{-1, 0, 0, 1};
    static int[] dy = new int[]{0, 1, -1, 0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt();
        int C = sc.nextInt();
        String D = sc.next();
        // Please write your code here.
        R -= 1;
        C -= 1;

        int d = getDir(D.charAt(0));

        for(int i = 0; i < T; i++) {
            int nx = R + dx[d];
            int ny = C + dy[d];

            if (inRange(nx, ny)) {
                R = nx;
                C = ny;
            } else {
                d = (3 - d);
            }
        }
        R++;
        C++;
        System.out.println(R + " " + C);
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    static int getDir(char a) {
        if(a == 'U') {
            return 0;
        } else if(a == 'R') {
            return 1;
        } else if(a == 'L') {
            return 2;
        } else {
            return 3;
        }
    }
}