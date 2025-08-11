import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair> {
        int w;
        int v;

        public Pair(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Pair p) {
            return p.v - this.v;
        }
    }

    static PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
    static Pair[] jewels;
    static Long[] bag;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewels = new Pair[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            jewels[i] = new Pair(w, v);
        }

        bag = new Long[K];
        for (int i = 0; i < K; i++) {
            long w = Long.parseLong(br.readLine());
            bag[i] = w;
        }

        Arrays.sort(jewels, Comparator.comparingInt(j -> j.w));
        Arrays.sort(bag);
        int jewelIdx = 0;
        long answer = 0;
        for (long cap : bag) {
            while (jewelIdx < N && jewels[jewelIdx].w <= cap) {
                pq.add(jewels[jewelIdx]);
                jewelIdx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll().v;
            }
        }

        System.out.println(answer);
    }
}
