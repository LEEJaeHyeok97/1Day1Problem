import java.util.*;

// N 명 사람
// 1 ~N 각 사람이 사용한 컴퓨터 번호를 구하는 프로그램
// 2~N+1 까지 p,q
class Point implements Comparable<Point> {
    int x;
    int v;
    int index;

    public Point(int x, int v, int index) {
        this.x = x;
        this.v = v;
        this.index = index;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            points.add(new Point(a, 1, i));
            points.add(new Point(b, -1, i));
        }

        Collections.sort(points);
        PriorityQueue<Integer> available = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) available.add(i);
        int[] answer = new int[n];
        for(Point p : points) {
            if(p.v == 1) {
                answer[p.index] = available.poll();
            } else {
                available.add(answer[p.index]);
            }
        }

        for(int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}