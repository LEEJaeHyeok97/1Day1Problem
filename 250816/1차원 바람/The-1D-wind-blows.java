import java.util.*;
import java.io.*;

// 큐에 밀린 행의 위아래 행을 담고
// 큐에서 뺀 행이 밀린 행과 같은게 있는지 검사
// 열 값이 같은게 있다면 전에 밀린 방향과 반대 방향으로 밀기
// 행 값이 0또는 N-1이면 해당 행도 진행 후 종료

public class Main {

    static int N, M;
    static int Q;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int tmp = 0;
        for (int qi = 0; qi < Q; qi++) {
            st = new StringTokenizer(br.readLine());
            int cur_row = Integer.parseInt(st.nextToken()) - 1; // 입력 행은 1부터 입력됨. 실제는 0
            Character d = st.nextToken().charAt(0);

            Character up_flag;
            Character down_flag;
            if (d.equals('L')) {
                left_wind(cur_row);
                up_flag = 'L';
                down_flag = 'L';
            } else {
                right_wind(cur_row);
                up_flag = 'R';
                down_flag = 'R';
            }

            // 위쪽방향 전파
            // 열 검증
            // 바람 불기
            for (int i = cur_row - 1; i >= 0; i--) {
                // 열 검증
                boolean flag = false;
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == graph[i + 1][j]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    if (up_flag == 'L') {
                        right_wind(i);
                        up_flag = 'R';
                    } else {
                        left_wind(i);
                        up_flag = 'L';
                    }
                } else {
                    break;
                }
            }


            // 아래쪽 방향 전파
            //열 검증
            // 바람 불기
            for (int i = cur_row + 1; i < N; i++) {
                // 열 검증
                boolean flag = false;
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == graph[i - 1][j]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    if (down_flag == 'L') {
                        right_wind(i);
                        down_flag = 'R';
                    } else {
                        left_wind(i);
                        down_flag = 'L';
                    }
                } else {
                    break;
                }
            }
        }

//        System.out.println(Arrays.deepToString(graph));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void right_wind(int cur_row) {
        int tmp;
        tmp = graph[cur_row][0];
        int[] tmp_arr = new int[M];
        for (int i = M - 1; i > 0; i--) {
            tmp_arr[i - 1] = graph[cur_row][i];
        }
        tmp_arr[M - 1] = tmp;

        for (int i = 0; i < M; i++) {
            graph[cur_row][i] = tmp_arr[i];
        }
    }

    private static void left_wind(int cur_row) {
        int tmp;
        tmp = graph[cur_row][M - 1];
        int[] tmp_arr = new int[M];
        for (int i = 0; i < M - 1; i++) {
            tmp_arr[i + 1] = graph[cur_row][i];
        }
        tmp_arr[0] = tmp;

        for (int i = 0; i < M; i++) {
            graph[cur_row][i] = tmp_arr[i];
        }
    }
}
