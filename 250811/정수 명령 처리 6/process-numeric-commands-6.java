import java.util.*;
import java.io.*;

public class Main {

    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                pq.add(-number);
            } else if (command.equals("size")) {
                System.out.println(pq.size());
            } else if (command.equals("empty")) {
                if (!pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println("1");
                }
            } else if (command.equals("pop")) {
                int number = -pq.poll();
                System.out.println(number);
            } else if (command.equals("top")) {
                System.out.println(-pq.peek());
            }
        }
    }
}
