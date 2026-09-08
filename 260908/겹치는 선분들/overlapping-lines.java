import java.util.*;

// 1~N 선분
// 선분 1은 원점에서 M(1) 만큼 왼쪽 혹은 오른쪽으로 그려진다.
// 선분 2는 선분 1을 그리고 마친 지점에서 M(2)만큼 왼쪽 혹은 오른쪽으로 그려진다.
// K개 이상 겹치는 곳의 길이의 합을 구하는 프로그램
class Point implements Comparable<Point> {
    long x;
    long v;

    public Point(long x, long v) {
        this.x = x;
        this.v = v;
    }

    @Override
    public int compareTo(Point p) {
        return Long.compare(this.x, p.x);
    }
}
public class Main {

    static final int MAX_VALUE = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt(); // 겹치는 선분 수

        ArrayList<Point> points = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < n; i++) {
            int M = sc.nextInt();
            char dir = sc.next().charAt(0);

            if(dir == 'L') {
                points.add(new Point(cur-M, +1));
                points.add(new Point(cur, -1));

                cur -= M;
            } else {
                points.add(new Point(cur, +1));
                points.add(new Point(cur+M, -1));

                cur += M;
            }
        }

        Collections.sort(points);
        
        long ans = 0;
        long tmp = 0;
        boolean flag = false;
        long start = 0;
        for(int i = 0; i < 2*n; i++) {
            long x = points.get(i).x;
            long v = points.get(i).v;

            tmp += v;

            if(tmp >= k && !flag) {
                flag = true;
                start = x;
            }
            else if(flag && k > tmp) {
                ans += Math.abs(x - start);
                flag = false;
            }
        }

        System.out.println(ans);
    }
}