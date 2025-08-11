import java.util.*;
import java.io.*;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                if (!pq.isEmpty()) {
                    int value = -pq.poll();
                    System.out.println(value);
                } else {
                    System.out.println("0");
                }
            } else if (number > 0) {
                pq.add(-number);
            }
        }
    }
}
