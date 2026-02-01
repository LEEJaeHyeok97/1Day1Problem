import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        grid = new int[4][4];

        int filled = 0;
        while (filled < 16) {
            String line = br.readLine();
            if (line == null) break;
            if (line.trim().isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens() && filled < 16) {
                int val = Integer.parseInt(st.nextToken());
                grid[filled / 4][filled % 4] = val;
                filled++;
            }
        }

        char dir = 0;
        while (dir == 0) {
            String line = br.readLine();
            if (line == null) break;
            if (line.trim().isEmpty()) continue;

            StringTokenizer st = new StringTokenizer(line);
            if (st.hasMoreTokens()) {
                dir = st.nextToken().charAt(0);
            }
        }

        gravityMove(dir);
        gravitySum(dir);
        gravityMove(dir);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(grid[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    static void gravityMove(char d) { // 옮기기
        if (d == 'L') {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int idx = 1;
                    while (inRange(i, j - idx)) {
                        if (grid[i][j - idx] == 0) {
                            grid[i][j - idx] = grid[i][j - idx + 1];
                            grid[i][j - idx + 1] = 0;
                        }
                        idx += 1;
                    }
                }
            }
        }

        if (d == 'R') {
            for (int i = 0; i < 4; i++) {
                for (int j = 3; j >= 0; j--) {
                    int idx = 1;
                    while (inRange(i, j + idx)) {
                        if (grid[i][j + idx] == 0) {
                            grid[i][j + idx] = grid[i][j + idx - 1];
                            grid[i][j + idx - 1] = 0;
                        }
                        idx += 1;
                    }
                }
            }
        }

        if (d == 'U') {
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 4; i++) {
                    int idx = 1;
                    while (inRange(i - idx, j)) {
                        if (grid[i - idx][j] == 0) {
                            grid[i - idx][j] = grid[i - idx + 1][j];
                            grid[i - idx + 1][j] = 0;
                        }
                        idx += 1;
                    }
                }
            }
        }

        if (d == 'D') {
            for (int j = 0; j < 4; j++) {
                for (int i = 3; i >= 0; i--) {
                    int idx = 1;
                    while (inRange(i + idx, j)) {
                        if (grid[i + idx][j] == 0) {
                            grid[i + idx][j] = grid[i + idx - 1][j];
                            grid[i + idx - 1][j] = 0;
                        }
                        idx += 1;
                    }
                }
            }
        }
    }

    static void gravitySum(char d) { // 합치기
        if (d == 'L') {
            for (int i = 0; i < 4; i++) {
                int prev = -1;
                for (int j = 0; j < 4; j++) {
                    if (prev == grid[i][j]) {
                        if (grid[i][j] != 0) {
                            grid[i][j] = grid[i][j] * 2;
                            grid[i][j - 1] = 0;
                            prev = -1;
                        }
                        continue;
                    }
                    prev = grid[i][j];
                }
            }
        }

        if (d == 'R') {
            for (int i = 0; i < 4; i++) {
                int prev = -1;
                for (int j = 3; j >= 0; j--) {
                    if (prev == grid[i][j]) {
                        if (grid[i][j] != 0) {
                            grid[i][j] = grid[i][j] * 2;
                            grid[i][j + 1] = 0;
                            prev = -1;
                        }
                        continue;
                    }
                    prev = grid[i][j];
                }
            }
        }

        if (d == 'U') {
            for (int j = 0; j < 4; j++) {
                int prev = -1;
                for (int i = 0; i < 4; i++) {
                    if (prev == grid[i][j]) {
                        if (grid[i][j] != 0) {
                            grid[i][j] = grid[i][j] * 2;
                            grid[i - 1][j] = 0;
                            prev = -1;
                        }
                        continue;
                    }
                    prev = grid[i][j];
                }
            }
        }

        if (d == 'D') {
            for (int j = 0; j < 4; j++) {
                int prev = -1;
                for (int i = 3; i >= 0; i--) {
                    if (prev == grid[i][j]) {
                        if (grid[i][j] != 0) {
                            grid[i][j] = grid[i][j] * 2;
                            grid[i + 1][j] = 0;
                            prev = -1;
                        }
                        continue;
                    }
                    prev = grid[i][j];
                }
            }
        }
    }

    static boolean inRange(int i, int j) {
        return (i >= 0 && i < 4) && (j >= 0 && j < 4);
    }
}
