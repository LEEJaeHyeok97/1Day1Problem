import java.util.*;

// N개의 구간, 모든 구간을 합친 후 총 구간 크기의 합
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
        int n = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            points.add(new Point(a, 1));
            points.add(new Point(b, -1));
        }

        Collections.sort(points);

        int ans = 0;
        int sumValue = 0;
        int prev = 0;
        for(int i = 0; i < 2*n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;

            sumValue += v;

            if(sumValue == 1 && v == 1) {
                prev = x;
            }
            else if(sumValue == 0 && v == -1) {
                ans += (x - prev);
                prev = 0;
            }
        }

        System.out.println(ans);
    }
}