import java.util.*;
import java.io.*;

public class Main {
    public static HashMap<Integer, Integer> dict = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (!dict.containsKey(v)) {
                dict.put(v, 1);
            } else {
                dict.put(v, dict.get(v) + 1);
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (!dict.containsKey(v)) {
                System.out.print(0 + " ");
            } else {
                System.out.print(dict.get(v) + " ");
            }
        }
    }
}