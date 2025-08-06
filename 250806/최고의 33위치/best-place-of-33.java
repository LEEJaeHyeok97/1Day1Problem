import java.io.*;
import java.util.*;

public class Main {
    public static int N;

    public static int[][] graph;
    public static ArrayList<Integer> ans = new ArrayList<>();

    public static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println("Arrays.deepToString(graph) = " + Arrays.deepToString(graph));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int tmp = 0;
                if (graph[i][j] == 1) {
                    tmp += 1;
                }

                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if ((0 > nx || nx >= N) || (0 > ny || ny >= N)) {
                        continue;
                    }
                    if (graph[nx][ny] == 0) {
                        continue;
                    }
                    tmp += graph[nx][ny];
                }
                ans.add(tmp);
            }
        }

        System.out.println(Collections.max(ans));

    }
}
