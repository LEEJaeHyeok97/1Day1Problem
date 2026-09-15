import java.util.*;

class Point implements Comparable<Point>{
    int x;
    int v;
    int idx;

    public Point(int x, int v, int idx) {
        this.x = x;
        this.v = v;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point point) {
        if(this.x != point.x) return this.x - point.x;
        return point.v - this.v;
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

            points.add(new Point(x1, 1, i + 1));
            points.add(new Point(x2, -1, i + 1));
        }

        Collections.sort(points);
        long[] arr = new long[n + 1];
        long total = 0;
        int cnt = 0;
        int sum = 0;
        int prev = points.get(0).x;
        for(Point point : points) {
            int x = point.x;
            int v = point.v;
            int idx = point.idx;

            long len = point.x - prev;
            // 1. cnt >= 1 이면 total에 len 더하기
            if(cnt >= 1) {
                total += len;
            }
            // 2. cnt == 1 이면 arr[sum]에 len 더하기
            if(cnt == 1) {
                arr[sum] += len;
            }
            
            // 3. cnt와 sum에 v와 v*idx 반영
            cnt += v;
            sum += v*idx;
            
            // 4. prev = point.x
            prev = x;
        }

        long ans = Long.MAX_VALUE;
        for(int i = 1; i < arr.length; i++) {
            ans = Math.min(ans, arr[i]);
        }
        System.out.println(total - ans);
    }
}