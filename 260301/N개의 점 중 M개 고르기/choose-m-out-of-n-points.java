import java.util.*;

// 유클리디안 거리 -> 점 M개를 적절히 선택하여 선택한 점들 중 거리가 가장 먼 두 점 사이의
// 거리값이 최소가 되도록 하는 프로그램
public class Main {

    static int ans = Integer.MAX_VALUE;
    static int n, m;
    static int[][] points;

    static ArrayList<Integer> selected = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        choose(0, 0);

        System.out.println((int)Math.pow(Math.sqrt(ans), 2));
    }

    static void choose(int curNum, int cnt) {
        if(cnt == m) {
            ans = Math.min(ans, calc());
            return;
        }
        if(curNum == n) {
            return;
        }

        selected.add(curNum);
        choose(curNum + 1, cnt + 1);
        selected.remove(selected.size() - 1);

        choose(curNum + 1, cnt);
    }

    static int calc() {
        int gap = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = i+1; j < m; j++) {
                int t1 = selected.get(i);
                int t2 = selected.get(j);

                int tmp = ((int)Math.pow(points[t1][0] - points[t2][0], 2) + (int)Math.pow(points[t1][1] - points[t2][1], 2));
                // System.out.println(tmp);
                gap = Math.max(gap, tmp);
            }
        }

        // System.out.println(gap);
        return gap;
    }
}