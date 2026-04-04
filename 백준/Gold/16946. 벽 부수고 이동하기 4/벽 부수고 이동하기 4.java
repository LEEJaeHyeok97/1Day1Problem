import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int[][] board;
    static int[][] group;
    static int[] groupSize;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        group = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        groupSize = new int[n * m + 1];

        int groupNumber = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && group[i][j] == 0) {
                    int size = bfs(i, j, groupNumber);
                    groupSize[groupNumber] = size;
                    groupNumber++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    sb.append(calculateMoveCount(i, j) % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static int bfs(int startX, int startY, int groupNumber) {
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(startX, startY));
        group[startX][startY] = groupNumber;

        int count = 1;

        while (!q.isEmpty()) {
            Pair current = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];

                if (isNotValid(nx, ny)) {
                    continue;
                }

                if (board[nx][ny] == 1) {
                    continue;
                }

                if (group[nx][ny] != 0) {
                    continue;
                }

                group[nx][ny] = groupNumber;
                q.offer(new Pair(nx, ny));
                count++;
            }
        }

        return count;
    }

    static int calculateMoveCount(int x, int y) {
        int result = 1;
        Set<Integer> set = new HashSet<>();

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (isNotValid(nx, ny)) {
                continue;
            }

            if (board[nx][ny] == 1) {
                continue;
            }

            int nearGroup = group[nx][ny];

            if (set.contains(nearGroup)) {
                continue;
            }

            set.add(nearGroup);
            result += groupSize[nearGroup];
        }

        return result;
    }

    static boolean isNotValid(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}