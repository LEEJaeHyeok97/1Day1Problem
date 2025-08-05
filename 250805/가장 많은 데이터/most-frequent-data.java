import java.util.*;
import java.io.*;

public class main {
    public static final int MAX_N = 100000;

    public static int n;
    public static String[] words = new String[MAX_N];
    public static HashMap<String, Integer> freq = new HashMap<>();

    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

//        System.out.println("n = " + n);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            words[i] = st.nextToken();
        }

        for (int i = 0; i < n; i++) {
            if (!freq.containsKey(words[i])) {
                freq.put(words[i], 1);
            } else {
                freq.put(words[i], freq.get(words[i]) + 1);
            }
            ans = Math.max(ans, freq.get(words[i]));
        }

        System.out.println(ans);
    }
}