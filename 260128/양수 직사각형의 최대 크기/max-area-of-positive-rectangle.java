import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(st.nextToken());
        }

        int best = -1;

        // 모든 직사각형 (r1,c1)~(r2,c2) 완전탐색
        for (int r1 = 0; r1 < N; r1++) {
            for (int c1 = 0; c1 < M; c1++) {
                for (int r2 = r1; r2 < N; r2++) {
                    for (int c2 = c1; c2 < M; c2++) {
                        if (allPositive(r1, c1, r2, c2)) {
                            int area = (r2 - r1 + 1) * (c2 - c1 + 1);
                            best = Math.max(best, area);
                        }
                    }
                }
            }
        }

        System.out.println(best);
    }

    static boolean allPositive(int r1, int c1, int r2, int c2) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (a[i][j] <= 0) return false; // 한 칸이라도 0이나 음수면 실패
            }
        }
        return true;
    }
}
