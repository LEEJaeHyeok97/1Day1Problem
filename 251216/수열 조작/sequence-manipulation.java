import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 1; i < n + 1; i++) {
            dq.addLast(i);
        }

        while(dq.size() != 1) {
            dq.pollFirst();
            int tmp = dq.pollFirst();
            dq.addLast(tmp);
        }

        System.out.println(dq.peekFirst());
    }
}