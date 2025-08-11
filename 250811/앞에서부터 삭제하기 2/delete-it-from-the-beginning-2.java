import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int MAX_N = 100000;

    static int n;
    static int[] arr = new int[MAX_N];
    static int sumVal;
    static double maxAvg;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            arr[i] = number;
        }

        pq.add(arr[n - 1]);
        sumVal += arr[n - 1];

        for (int i = n - 2; i >= 1; i--) {
            pq.add(arr[i]);
            sumVal += arr[i];

            double avg = (double) (sumVal - pq.peek()) / (n - i - 1);

            if (maxAvg < avg) {
                maxAvg = avg;
            }
        }

        System.out.printf(".2f", maxAvg);


    }
}

