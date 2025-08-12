import java.util.*;
import java.io.*;

public class Main {

    static Character[] li;
    static Deque<Character> stack = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        li = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            li[i] = c;
        }

        for (int i = 0; i < li.length; i++) {
            if (li[i].equals('(')) {
                stack.add(li[i]);
            } else if (li[i].equals(')')) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                } else {
                    System.out.println("No");
                    System.exit(0);
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
