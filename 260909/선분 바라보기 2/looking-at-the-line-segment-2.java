import java.util.*;

// x축에 평행한 서로 다른 선분 n개 
// y값이 아주 작은 지점에서 바라봤을 때 보이는 서로 다른 색깔의 수
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
        return Integer.compare(this.x, p.x);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            int y = sc.nextInt();
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();

            points.add(new Point(x1, 1, i));
            points.add(new Point(x2, -1, i));
            ys[i] = y;
        }

        Collections.sort(points);

        int ans = 0;
        boolean[] visible = new boolean[n];
        TreeSet<Integer> set = new TreeSet<>((a,b) -> ys[a] != ys[b] ? Integer.compare(ys[a],ys[b]) : Integer.compare(a,b));
        for(int i = 0; i < 2*n; i++) {
            int x = points.get(i).x;
            int index = points.get(i).index;
            int v = points.get(i).v;

            if(v == 1) {
                set.add(index);
            } else if(v == -1) {
                set.remove(index);
            }
            if (!set.isEmpty()) visible[set.first()] = true;
        }

        for (boolean b : visible) if (b) ans++;

        System.out.println(ans);
    }
}