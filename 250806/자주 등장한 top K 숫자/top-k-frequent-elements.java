import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair implements Comparable<Pair> {
    int cnt, num;

    public Pair(int cnt, int num) {
        this.cnt = cnt;
        this.num = num;
    }

    @Override
    public int compareTo(Pair o) {
        if (cnt != o.cnt) {
            return cnt - o.cnt;
        }
        return num - o.num;
    }
}

public class Main {
    public static final int MAX_N = 100000;

    public static int n, k;
    public static int[] arr = new int[MAX_N];
    public static HashMap<Integer, Integer> freq = new HashMap<>();
    public static ArrayList<Pair> v = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (!freq.containsKey(arr[i])) {
                freq.put(arr[i], 1);
            } else {
                freq.put(arr[i], freq.get(arr[i]) + 1);
            }
        }

        for (Integer key : freq.keySet()) {
            v.add(new Pair(freq.get(key), key));
        }

        Collections.sort(v);

        for (int i = v.size() - 1; i >= v.size() - k; i--) {
            System.out.print(v.get(i).num + " ");
        }
    }
}