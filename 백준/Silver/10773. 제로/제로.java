import java.io.*;
import java.util.*;

public class Main {

    static int k;
    static int ans = 0;

    static Deque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                stack.pollLast();
                continue;
            }

            stack.add(number);
        }

        while (!stack.isEmpty()) {
            ans += stack.pollLast();
        }

        System.out.println(ans);
    }
}
