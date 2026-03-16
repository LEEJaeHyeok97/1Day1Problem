import java.util.*;
import java.io.*;
public class Main {

    static Deque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String operator = st.nextToken();

            if (operator.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                stack.add(num);
            }
            if (operator.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.peekLast());
                }
            }
            if (operator.equals("size")) {
                System.out.println(stack.size());
            }
            if (operator.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
            if (operator.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }

                System.out.println(stack.pollLast());
            }
        }
    }
}
