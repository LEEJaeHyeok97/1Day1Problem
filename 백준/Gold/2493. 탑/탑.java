import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 탑의 기둥 모두에는 레이저 신호를 수신하는 장치가 설치되어 있다.
class Tower {
    int idx;
    int height;

    public Tower(int idx, int height) {
        this.idx = idx;
        this.height = height;
    }
}

public class Main {

    static Deque<Tower> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                stack.add(new Tower(i, height));
                sb.append(0 + " ");
                continue;
            }

            while (!stack.isEmpty() && stack.peekLast().height < height) {
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                sb.append(0 + " ");
            } else {
                sb.append(stack.peekLast().idx + 1 + " ");
            }
            stack.add(new Tower(i, height));
        }

        System.out.println(sb);
    }
}
