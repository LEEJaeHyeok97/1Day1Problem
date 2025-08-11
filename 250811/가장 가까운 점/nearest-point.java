import java.util.*;

public class Main {

    static PriorityQueue<Point> pq = new PriorityQueue<>();
    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        // priority queue에 점을 넣어줍니다.
        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pq.add(new Point(x, y));
        }

        for (int i = 0; i < m; i++) {
            Point p = pq.poll();

            p.x +=2;
            p.y += 2;
            pq.add(p);
        }

        Point p = pq.poll();
        System.out.println(p.x + " " + p.y);

    }
}

class Point implements Comparable<Point>  {

    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // x + y, x, y 순으로 우선순위가 되도록 한다.
    @Override
    public int compareTo(Point p) {
        if (this.x + this.y != p.x + p.y) {
            return (this.x + this.y) - (p.x + p.y);
        }
        if (this.x != p.x) {
            return this.x - p.x;
        } else {
            return this.y - p.y;
        }
    }
}