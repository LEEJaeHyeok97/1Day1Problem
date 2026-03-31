import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();

            pq.add(number);
        }
        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }

        int ans = 0;
        while (pq.size() != 1) {
            Integer a = pq.poll();
            Integer b = pq.poll();
            ans += (a + b);
            pq.add(a + b);
        }

        System.out.println(ans);
    }
}
