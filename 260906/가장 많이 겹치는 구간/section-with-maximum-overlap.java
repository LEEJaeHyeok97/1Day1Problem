import java.util.*;

class Point implements Comparable<Point> {
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
        ArrayList<Point> points = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            points.add(new Point(x1, 1));
            points.add(new Point(x2, -1));
        }

        
        Collections.sort(points);

        int ans = 0;
        int sum = 0;
        for(Point point : points) {
            sum += point.v;
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}