import java.io.*;
import java.util.*;

// N번의 명령으로 움직인다.
// x L : 왼쪽 이동 현재 타일 포함 총 x칸 W칠
// x R : 오른쪽 이동 현재 타일 포함 총 x칸 B칠
// 각 명령 이후 마지막으로 칠한 타일 위에서 있는다고 가정
// 타일의 색은 덧칠해지면 마지막으로 칠해진 색으로 바뀌는데
// 순서 상관 없이 흰2+검2 이상 칠해지면 회색으로 바뀌고 더 이상 바뀌지 않는다.
public class Main {
    static final int MAX_RANGE = 200001;
    static final int OFFSET = 100000;
    static int N;
    static int[] arr = new int[MAX_RANGE];
    static String[] color = new String[MAX_RANGE];
    static int[] W = new int[MAX_RANGE];
    static int[] B = new int[MAX_RANGE];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < MAX_RANGE; i++) {
            color[i] = "";
        }

        int cur = 0;
        int x;
        String direction;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            direction = st.nextToken();

            int nx1 = OFFSET;
            int nx2 = OFFSET;
            if (direction.equals("L")) {
                nx1 += cur - (x - 1);
                nx2 += cur;

                for (int ni = nx1; ni <= nx2; ni++) {
                    if (!color[ni].equals("G")) {
                        W[ni] += 1;
                        if (W[ni] >= 2 && B[ni] >= 2) {
                            color[ni] = "G";
                        } else {
                            color[ni] = "W";
                        }
                    }
                }

                cur -= (x - 1);
            } else {
                nx1 += cur;
                nx2 += cur + (x - 1);

                for (int ni = nx1; ni <= nx2; ni++) {
                    if (!color[ni].equals("G")) {
                        B[ni] += 1;
                        if (W[ni] >= 2 && B[ni] >= 2) {
                            color[ni] = "G";
                        } else {
                            color[ni] = "B";
                        }
                    }
                }
                cur += (x - 1);
            }
        }

        int GCount = 0;
        int WCount = 0;
        int BCount = 0;

        for (int i = 0; i < MAX_RANGE; i++) {
            if (color[i].equals("W")) {
                WCount += 1;
            } else if (color[i].equals("B")) {
                BCount += 1;
            } else if (color[i].equals("G")) {
                GCount += 1;
            }
        }

        System.out.println(WCount + " " + BCount + " " + GCount);

    }
}
