import java.io.*;
import java.util.*;

public class Main {
    public static TreeMap<String, Integer> m = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String color = br.readLine();

            if (!m.containsKey(color)) {
                m.put(color, 1);
            } else {
                m.put(color, m.get(color) + 1);
            }
        }

        Iterator<Map.Entry<String, Integer>> it = m.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            String word = entry.getKey();
            Integer cnt = entry.getValue();
            double ratio = (double) cnt / N * 100;

            System.out.printf("%s %.4f\n", word, ratio);
        }
    }
}