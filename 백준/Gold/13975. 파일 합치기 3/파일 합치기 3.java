import java.util.*;
import java.io.*;

// 최종 하나의 파일로 만드는데 필요한 비용의 총 합 계산
// 40, 30, 30, 50 -> 310  ( C2, C3 부터 시작 시)
// C1, C2부터 합치고 C3, C4 합친 후 Y1, Y2를 합치면 -> 300 더 저렴
// 이 파일들을 하나로 합칠 때 최소비용을 계산하는 프로그램을 작성하시오.
// 60 40 50 -> 90 60 -> 150
// 1 21 3 4 5 35 5 4 3 5 98 21 14 17 32
// 4 21 4 5 35 5 4 3 5 98 21 14 17 32 ==> 4
// 4 21 4 5 35 5 5 7 98 21 14 17 32 ==> 11
// 8 21 5 35 5 5 7 98 21 14 17 32 ==> 19
// 8 21 5 35 10 7 98 21 14 17 32 ==> 29
// 8 21 35 10 12 98 21 14 17 32 ==> 41
// 18 21 35 12 98 21 14 17 32 ==> 59
// 18 21 35 26 98 21 17 32 ==> 85
// 21 35 26 98 21 35 32 ==> 120
// 42 35 26 98 35 32 ==> 162
// 42 35 98 35 58 ==> 220
// 42 98 70 58 ==> 290
// 100 98 70 ==> 390
// 100 168 ==> 558
// 268 ==> 826
public class Main {

    static PriorityQueue<Long> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            pq = new PriorityQueue<>();

            for (int j = 0; j < K; j++) {
                long number = Integer.parseInt(st.nextToken());
                pq.add(number);
            }

            long ans = 0;
            while (!pq.isEmpty()) {
                if (pq.size() == 1) {
                    break;
                }
                long a = pq.poll();
                long b = pq.poll();

                ans += (a + b);
                pq.add((a + b));
            }

            System.out.println(ans);
        }
    }
}
