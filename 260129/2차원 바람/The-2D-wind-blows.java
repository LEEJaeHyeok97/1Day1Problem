import java.util.*;
public class Main {
    static int[][] building;
    static int n, m, q;
    static int[][] queries;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();

        building = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                building[i][j] = sc.nextInt();
        queries = new int[q][4];
        for (int i = 0; i < q; i++)
            for (int j = 0; j < 4; j++)
                queries[i][j] = sc.nextInt();

        // Please write your code here.
        for(int i = 0; i < q; i++) {
            // int[][] nextBuilding = new int[n][m];
            rotate(i);
            calculateBuilding(i);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(building[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate(int queryIdx) {
        int r1 = queries[queryIdx][0] - 1;
        int c1 = queries[queryIdx][1] - 1;
        int r2 = queries[queryIdx][2] - 1;
        int c2 = queries[queryIdx][3] - 1;

        int saved = building[r1][c1];

        // left col: up
        for (int r = r1; r < r2; r++) {
            building[r][c1] = building[r + 1][c1];
        }

        // bottom row: left
        for (int c = c1; c < c2; c++) {
            building[r2][c] = building[r2][c + 1];
        }

        // right col: down
        for (int r = r2; r > r1; r--) {
            building[r][c2] = building[r - 1][c2];
        }

        // top row: right
        for (int c = c2; c > c1 + 1; c--) {
            building[r1][c] = building[r1][c - 1];
        }

        building[r1][c1 + 1] = saved;
    }

    static void calculateBuilding(int queryIdx) {
    int r1 = queries[queryIdx][0] - 1;
    int c1 = queries[queryIdx][1] - 1;
    int r2 = queries[queryIdx][2] - 1;
    int c2 = queries[queryIdx][3] - 1;

    // 회전 직후 상태 스냅샷
    int[][] copy = new int[n][m];
    for (int i = 0; i < n; i++) {
        copy[i] = building[i].clone();
    }

    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    // 사각형 내부만 바람(평균) 적용
    for (int r = r1; r <= r2; r++) {
        for (int c = c1; c <= c2; c++) {
            int sum = copy[r][c];
            int cnt = 1;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                // 이웃이 "사각형 내부"에 있을 때만 포함
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    sum += copy[nr][nc];
                    cnt++;
                }
            }

            building[r][c] = sum / cnt; // 정수 나눗셈
        }
    }
    }
}