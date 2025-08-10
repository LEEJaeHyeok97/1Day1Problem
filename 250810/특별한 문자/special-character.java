import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static HashMap<String, int[]> m = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] tmpArray = s.split("");

        int cnt = 1;
        for (int i = 0; i < tmpArray.length; i++) {
            if (m.containsKey(tmpArray[i])) {
                m.put(tmpArray[i], new int[]{m.get(tmpArray[i])[0] + 1, m.get(tmpArray[i])[1]});
            } else {
                m.put(tmpArray[i], new int[]{1, cnt});
            }
            cnt += 1;
        }

        Character max_c = null;
        int max_o = 100001;
        for (String key : m.keySet()) {
            int v = m.get(key)[0];
            int o = m.get(key)[1];

            if (v == 1) {
                if (max_o > o) {
                    max_o = o;
                    max_c = key.charAt(0);
                }
            }
        }

        System.out.println(max_c);
    }
}
