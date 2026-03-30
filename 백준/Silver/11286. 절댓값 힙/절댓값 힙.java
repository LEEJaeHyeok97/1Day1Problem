import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int n;
    static PriorityQueue<Integer> positivePq = new PriorityQueue<>();
    static PriorityQueue<Integer> negativePq = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        while (n-- > 0) {
            int number = scanner.nextInt();

            if (number == 0) {
                if (positivePq.isEmpty() && negativePq.isEmpty()) {
                    System.out.println(0);
                } else {
                    if (positivePq.isEmpty()) {
                        System.out.println(-negativePq.poll());
                    } else if (negativePq.isEmpty()) {
                        System.out.println(positivePq.poll());
                    } else if (Math.abs(positivePq.peek()) < Math.abs(negativePq.peek())) {
                        System.out.println(positivePq.poll());
                    } else {
                        System.out.println(-negativePq.poll());
                    }
                }
            } else {
                if (number > 0) {
                    positivePq.add(Math.abs(number));
                } else {
                    negativePq.add(Math.abs(number));
                }
            }
        }
    }
}
