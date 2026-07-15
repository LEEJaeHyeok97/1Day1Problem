import java.util.*;

// 각 질의에 대해 주어진 점 마다 가장 친근한 점을 찾아 출력
// 친근한 점이기 위해서는 x < x` 혹은 (x=x`,y<=y) 
// 이 중 가장 친근한 점은 x좌표 값이 가장 작은 점, x좌표가 작은 점이 여러 개인 경우
// y좌표 값이 가장 작은 점이 가장 친근한 점이 된다.
class Pair implements Comparable<Pair> {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if(this.x != p.x) {
            return this.x - p.x;
        }
        else {
            return this.y - p.y;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        TreeSet<Pair> s = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();

            s.add(new Pair(x[i], y[i]));
        }
        int[] qx = new int[m];
        int[] qy = new int[m];
        for (int i = 0; i < m; i++) {
            qx[i] = sc.nextInt();
            qy[i] = sc.nextInt();
            Pair p = s.ceiling(new Pair(qx[i], qy[i]));
            if(p != null) {
                System.out.println(p.x + " " + p.y);
            } else {
                System.out.println("-1 -1");
            }
        }
    }
}