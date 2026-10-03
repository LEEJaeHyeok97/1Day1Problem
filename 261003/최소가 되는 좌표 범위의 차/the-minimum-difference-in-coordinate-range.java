import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point p) {
        return this.x - p.x;        // x 기준 오름차순 정렬
    }
}

class TargetPoint implements Comparable<TargetPoint> {
    int x, y;

    public TargetPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(TargetPoint p) {
        if(this.y != p.y)
            return this.y - p.y;                // y 기준 오름차순 정렬
        return this.x - p.x;                    // y가 동일할시 x 기준 오름차순 정렬
    }
}
public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n, d;
    public static Point[] point = new Point[MAX_N + 1];
    public static TreeSet<TargetPoint> pointCount = new TreeSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        for(int i = 1; i <=n ;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            point[i] = new Point(x, y);
        }

        Arrays.sort(point, 1, n+1);
        int ans = INT_MAX;

        int j = 0;
        for(int i = 1; i <= n; i++) {
            while(j + 1 <= n && getMax() - getMin() < d) {
                pointCount.add(new TargetPoint(point[j + 1].x, point[j + 1].y));
                j++;
            }

            if(getMax() - getMin() < d)
                break;
            
            ans = Math.min(ans, point[j].x - point[i].x);

            pointCount.remove(new TargetPoint(point[i].x, point[i].y));
        }

        if(ans == INT_MAX) System.out.print(-1);
        else System.out.print(ans);
    }

    public static int getMin() {
        if(pointCount.isEmpty()) return 0;
        return pointCount.first().y; 
    }
    
    public static int getMax() {
        if(pointCount.isEmpty()) return 0;
        return pointCount.last().y;
    }
}