import java.util.*;
import java.io.*;

public class Main {

    static Deque<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            if (command.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                q.add(number);
            } else if (command.equals("front")) {
                System.out.println(q.peek());
            } else if (command.equals("pop")) {
                int number = q.poll();
                System.out.println(number);
            } else if (command.equals("size")) {
                System.out.println(q.size());
            } else if (command.equals("empty")) {
                if (!q.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println("1");
                }
            }
        }
    }
}
