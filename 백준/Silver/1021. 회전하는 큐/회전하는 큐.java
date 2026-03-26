import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static LinkedList<Integer> dq = new LinkedList<Integer>();
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            int targetIdx = dq.indexOf(num);
            int halfIdx;

            if (dq.size() % 2 == 0) {
                halfIdx = dq.size() / 2 - 1;
            } else {
                halfIdx = dq.size() / 2;
            }

            if (targetIdx <= halfIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    int tmp = dq.pollFirst();
                    dq.add(tmp);
                    count++;
                }
            } else {
                for (int j = 0; j < dq.size() - targetIdx; j++) {
                    int tmp = dq.pollLast();
                    dq.addFirst(tmp);
                    count++;
                }
            }

            dq.pollFirst();
        }

        System.out.println(count);
    }
}
