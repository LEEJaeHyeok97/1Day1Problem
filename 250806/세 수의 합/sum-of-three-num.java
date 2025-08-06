import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static final int MAX_N = 1000;
    public static int N, K;

    public static int[] arr = new int[MAX_N];
    public static HashMap<Integer, Integer> freq = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (!freq.containsKey(arr[i])) {
                freq.put(arr[i], 1);
            } else {
                freq.put(arr[i], freq.get(arr[i]) + 1);
            }
        }

//        System.out.println("freq = " + freq);
        for (int i = 0; i < N; i++) {
            if (!freq.containsKey(arr[i])) {
                freq.put(arr[i], -1);
            } else {
                freq.put(arr[i], freq.get(arr[i]) - 1);
            }

            for (int j = 0; j < i; j++) {
                if (freq.containsKey(K - arr[i] - arr[j])) {
                    ans += freq.get(K - arr[i] - arr[j]);
                }
            }
        }

        System.out.println(ans);








    }
}
