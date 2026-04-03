import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        while (n-- > 0) {
            int number = scanner.nextInt();

            if (number == 0) {
                if (pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(-pq.poll());
                }
            } else {
                pq.add(-number);
            }
        }
    }
}
