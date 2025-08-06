import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;

    public static int n, k;
    public static long[] arr = new long[MAX_N];
    public static HashMap<Long, Integer> count = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            long diff = k - arr[i];

            if (count.containsKey(diff)) {
                ans += count.get(diff);
            }

            if (!count.containsKey(arr[i])) {
                count.put(arr[i], 1);
            } else {
                count.put(arr[i], count.get(arr[i]) + 1);
            }
        }
        System.out.println(ans);
    }
}