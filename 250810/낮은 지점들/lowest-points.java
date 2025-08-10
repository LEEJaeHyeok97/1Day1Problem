import java.io.*;
import java.util.*;

public class Main {
    public static HashMap<Integer, Integer> m = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (!m.containsKey(x)) {
                m.put(x, y);
            } else {
                if (m.get(x) > y) {
                    m.put(x, y);
                }
            }
        }

        Long answer = 0L;
        for (int v : m.keySet()) {
            answer += m.get(v);
        }
        System.out.println(answer);
    }
}
