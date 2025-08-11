import java.io.*;
import java.util.*;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            pq.add(-number);
        }

        while (pq.size() >= 2) {
            int num1 = -pq.poll();
            int num2 = -pq.poll();

            if ((num1 - num2) == 0) {
                continue;
            } else {
                int res = Math.abs(num1 - num2);
                pq.add(-res);
            }
        }
        if (!pq.isEmpty()) {
            System.out.println(-pq.peek());
        } else {
            System.out.println(-1);
        }
    }
}
