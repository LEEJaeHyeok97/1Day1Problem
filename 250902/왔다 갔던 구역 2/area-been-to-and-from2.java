import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int OFFSET = 1000;
    static final int MAX_R = 2000;
    static final int MAX_N = 100;

    static int n;
    static int[] x1 = new int[MAX_N];
    static int[] x2 = new int[MAX_N];

    static int[] checked = new int[MAX_R + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        int cur = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int distance = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);

            if (direction == 'L') {
                x1[i] = cur - distance;
                x2[i] = cur;
                cur -= distance;
            }
            else {
                x1[i] = cur;
                x2[i] = cur + distance;
                cur += distance;
            }

            x1[i] += OFFSET;
            x2[i] += OFFSET;
        }

        // 구간 칠하기
        for (int i = 0; i < n; i++) {
            for (int j = x1[i]; j < x2[i]; j++) {
                checked[j]++;
            }
        }


        int cnt = 0;
        for (int i = 0; i < MAX_R; i++) {
            if (checked[i] >= 2) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
