import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static TreeMap<Integer, Integer> m = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (!m.containsKey(number)) {
                m.put(number, i + 1);
            } else {
                continue;
            }
        }

        Iterator<Map.Entry<Integer, Integer>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            System.out.printf("%d %d", entry.getKey(), entry.getValue());
            System.out.println();
        }
    }
}
