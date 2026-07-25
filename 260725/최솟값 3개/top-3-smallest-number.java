import java.util.*;

// 숫자가 주어질 때마다 지금까지 주어진 숫자들 중 가장 작은 숫자 3개의 곱을 출력
// 3개가 되지 않는다면, -1을 출력
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            long num = sc.nextInt();

            pq.add(num);
            if(pq.size() < 3) {
                System.out.println(-1);
            } else {
                long[] tmp = new long[3];
                for(int j = 0; j < 3; j++) {
                    tmp[j] = pq.poll();
                }
                for(int j = 0 ; j < 3; j++) {
                    pq.add(tmp[j]);
                }

                System.out.println(tmp[0]*tmp[1]*tmp[2]);
            }
        }

    }
}