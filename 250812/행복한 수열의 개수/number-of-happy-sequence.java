// N X N (1~100)
// 행복한 수열 = 연속하여 M개 이상의 동일한 원소가 나오는 순간이 존재하는 수열

import java.util.*;
import java.io.*;

public class Main {

    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println(Arrays.deepToString(graph));

        // 행 검사
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            int prev = graph[i][0];
            for (int j = 1; j < N; j++) {
                if (prev == graph[i][j]) {
                    cnt += 1;
                } else {
                    prev = graph[i][j];
                    cnt = 1;
                }
                if (cnt == M) {
                    ans += 1;
                    break;
                }
            }
        }
//        System.out.println("first turn" + ans);

        // 열 검사
        for (int i = 0; i < N; i++) {
            int prev = graph[0][i];
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if (graph[j][i] == prev) {
                    cnt += 1;
                } else {
                    prev = graph[j][i];
                    cnt = 1;
                }
                if (cnt == M) {
                    ans += 1;
                    break;
                }
            }
        }
        System.out.println(ans);

    }
}
