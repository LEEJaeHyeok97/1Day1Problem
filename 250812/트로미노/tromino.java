package codingtest.codetree.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tromino {

    static int[][] graph;
    static int[][][] shapes = new int[][][]{
            {
                    {1, 1, 0},
                    {1, 0, 0},
                    {0, 0, 0}
            },
            {
                    {1, 0, 0},
                    {1, 1, 0},
                    {0, 0, 0}
            },
            {
                    {0, 1, 0},
                    {1, 1, 0},
                    {0, 0, 0}
            },
            {
                    {1, 1, 0},
                    {0, 1, 0},
                    {0, 0, 0}
            },
            {
                    {1, 1, 1},
                    {0, 0, 0},
                    {0, 0, 0}
            },
            {
                    {1, 0, 0},
                    {1, 0, 0},
                    {1, 0, 0}
            }
    };
    static int N;
    static int M;

    static int getMaxSum(int x, int y) {
        int maxSum = 0;

        for (int i = 0; i < 6; i++) {
            boolean isPossible = true;
            int sum = 0;
            for (int dx = 0; dx < 3; dx++) {
                for (int dy = 0; dy < 3; dy++) {
                    if (shapes[i][dx][dy] == 0) {
                        continue;
                    }
                    if (x + dx >= N || y + dy >= M) {
                        isPossible = false;
                    } else {
                        sum += graph[x+ dx][y + dy];
                    }
                }
            }
            if (isPossible) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ans = Math.max(ans, getMaxSum(i, j));
            }
        }

        System.out.println(ans);
    }
}
