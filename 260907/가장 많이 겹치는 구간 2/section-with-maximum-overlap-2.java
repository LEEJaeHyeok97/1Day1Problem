import java.util.*;

// N개 구간. 구간이 가장 많이 겹치는 부분에서 몇 개가 겹치는지 구하는 프로그램
class Point implements Comparable<Point>{
    int x;
    int v;

    public Point(int x, int v) {
        this.x = x;
        this.v = v;
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
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            points.add(new Point(x1, +1));
            points.add(new Point(x2, -1));
        }

        Collections.sort(points);
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < 2*n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;

            sum += v;
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}