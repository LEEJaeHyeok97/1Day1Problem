import java.util.*;

class Point implements Comparable<Point>{
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
        int[] a = new int[n];
        int[] b = new int[n];

        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();

            points.add(new Point(a[i], +1, i));
            points.add(new Point(b[i], -1, i));
        }

        Collections.sort(points);

        HashSet<Integer> segments = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < 2*n; i++) {
            int x = points.get(i).x;
            int v = points.get(i).v;
            int idx = points.get(i).index;

            if(v == +1) {
                if(segments.size() == 0) ans++;

                segments.add(idx);
            } else {
                segments.remove(idx);
            }
        }

        System.out.println(ans);
    }
}