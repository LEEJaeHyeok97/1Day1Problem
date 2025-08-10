import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static TreeMap<String, Integer> m = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (!m.containsKey(str)) {
                m.put(str, 1);
            } else {
                m.put(str, m.get(str) + 1);
            }
        }

        Iterator<Map.Entry<String, Integer>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
