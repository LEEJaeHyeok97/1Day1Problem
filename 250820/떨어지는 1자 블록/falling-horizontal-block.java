import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] graph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

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

        int start = K - 1;
        int end = start + M - 1;

        boolean flag = true;
            for (int i = 1; i < N; i++) {
                for (int j = start; j <= end; j++) {
                    if (graph[i][j] == 1) {
                        for (int k = start; k <= end; k++) {
                            graph[i - 1][k] = 1;
                        }
                        flag = false;
                    }
                    if (!flag) {
                        break;
                    }
                }
                if (!flag) {
                    break;
                }
            }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

    }
}
