import java.io.*;
import java.util.*;

// HashMap<Set, Integer>
public class Main {

    public static HashMap<String, Integer> m = new HashMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            char[] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            s = new String(tempArray);
            if (m.containsKey(s)) {
                m.put(s, m.get(s) + 1);
            } else {
                m.put(s, 1);
            }
        }

        int maxVal = 0;
        for (String key : m.keySet()) {
            maxVal = Math.max(maxVal, m.get(key));
        }

        System.out.println(maxVal);
    }
}
