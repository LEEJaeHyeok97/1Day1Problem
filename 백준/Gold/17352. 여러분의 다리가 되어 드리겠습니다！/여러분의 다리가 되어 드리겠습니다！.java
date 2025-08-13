import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N개의 섬이 존재.
// N - 1개의 다리가 존재.
// N - 2개의 다리가 결국 주어짐.
// 다리로 이을 두 섬의 번호를 출력. 여러 가지 방법이 있을 경우 그 중 아무거나 출력.

public class Main {

    static long[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long N = Long.parseLong(br.readLine());
        arr = new long[(int) (N + 1)];
        for (long i = 1; i < N; i++) {
            arr[(int) i] = i;
        }

        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        long root1 = find(1);
        for (int i = 2; i <= N; i++) {
            if (find(i) != root1) {
                System.out.println(1 + " " + i);
                return;
            }
        }

    }

    static void union(long a, long b) {
        long x = find(a);
        long y = find(b);
        if (x != y) {
            arr[(int) y] = x;
        }
    }

    static long find(long f) {
        if (arr[(int) f] != f) {
            arr[(int) f] = find(arr[(int) f]);
        }
        return arr[(int) f];
    }
}
