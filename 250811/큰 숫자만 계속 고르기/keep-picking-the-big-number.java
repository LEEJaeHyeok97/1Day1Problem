import java.util.*;
import java.io.*;

// N개의 숫자가 주어졌을 때
// 그 중 가장 큰 수를 골라 1씩 빼는 작업을 M번 반복
// 이후 남아있는 수들 중 최대값 출력
public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            pq.add(-number);
        }

        for (int i = 0; i < M; i++) {
            int max_number = -pq.poll();
            pq.add(-(max_number - 1));
        }

        System.out.println(-pq.peek());

    }
}
