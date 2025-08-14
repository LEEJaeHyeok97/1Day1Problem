import java.util.*;
import java.io.*;

// N * M 영역 안에서 가능한 양수 직사각형 중 최대 크기
// 최대 크기의 양수 직사각형을 찾으시오
// 가능한 양수 직사각형 중 최대 크기
// 없다면 -1, 있다면 직사각형의 최대 크기 출력

public class Main {

    static int N, M;
    static int[][] graph;
    static ArrayList<Rectangle> arr = new ArrayList<Rectangle>();
    static ArrayList<Integer> ans = new ArrayList<>();
    static class Rectangle {
        int x;
        int y;

        public Rectangle(int a, int b) {
            this.x = a;
            this.y = b;
        }
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

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                arr.add(new Rectangle(i, j));
            }
        }


        boolean flag = false;
        for (int k = 0; k < arr.size(); k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    Rectangle rectangle = arr.get(k);
                    int x = rectangle.x;
                    int y = rectangle.y;
                    int cnt = 0;

                    for (int m = 0; m < x; m++) {
                        int tmp = 0;
                        for (int l = 0; l < y; l++) {
                            int nx = i + m;
                            int ny = j + l;

                            flag = false;

                            tmp = 0;

                            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                                cnt += 1;
                                if (graph[nx][ny] < 0) {
                                    flag = true;
                                    break;
                                }
                            }
                        }
                        if (flag) {
                            break;
                        }
                        ans.add(cnt);
                    }




                }
            }
        }

        System.out.println(Collections.max(ans));
    }
}
