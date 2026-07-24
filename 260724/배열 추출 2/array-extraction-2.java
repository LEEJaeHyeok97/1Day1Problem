import java.util.*;

// 0이 아니면, 정수 x를 배열에 추가
// 0이면, 배열에서 절댓값이 가장 작은 정수를 출력한 후 제거
// 절댓값이 가장 작은 정수가 여러 개라면, 그 중 가장 작은 수를 선택.
// 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우 0을 출력
class Tuple implements Comparable<Tuple> {
    int num;
    int flag; // 0: 음수, 1: 양수

    public Tuple(int num, int flag) {
        this.num = num;
        this.flag = flag;
    }

    @Override
    public int compareTo(Tuple o) {
        if(this.num == o.num) {
            return Integer.compare(this.flag, o.flag);
        }

        return Integer.compare(this.num, o.num);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if(x != 0) {
                if(x < 0) {
                    pq.add(new Tuple(Math.abs(x), 0));
                } else {
                    pq.add(new Tuple(Math.abs(x), 1));
                }
            } else {
                if(pq.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                Tuple o = pq.poll();
                if(o.flag == 0) {
                    System.out.println(-o.num);
                } else {
                    System.out.println(o.num);
                }
            }
        }
    }
}