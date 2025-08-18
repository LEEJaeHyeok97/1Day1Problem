import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;

    static int[][] graph;
    static int[] block;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        block = new int[N];
        for (int i = 0; i < N; i++) {
            block[i] = 0;
        }
        for (int i = 0; i < M; i++) {
            block[K - 1 + i] = 1;
        }

        boolean flag = true;
        int cur_row = 0;
        int cur_col = K - 1;
        while (flag) {

            for (int j = cur_col; j < cur_col + M; j++) {
                if (graph[cur_row][j] == 1) {
                    cur_row -= 1;
                    for (int bi = cur_col; bi < K - 1 + M; bi++) {
                        graph[cur_row][bi] = block[bi];
                    }
                    flag = false;
                    break;
                }
            }

            cur_row++;
            cur_col = K - 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
