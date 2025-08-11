import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Deque<Integer> s = new ArrayDeque<>();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            if (command.equals("push")) {
                int number = Integer.parseInt(st.nextToken());
                s.add(number);
            } else if (command.equals("pop")) {
                int number = s.pollLast();
                System.out.println(number);
            } else if (command.equals("size")) {
                System.out.println(s.size());
            } else if (command.equals("empty")) {
                if (!s.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println("1");
                }
            } else if (command.equals("top")) {
                System.out.println(s.peekLast());
            }
        }

    }
}
