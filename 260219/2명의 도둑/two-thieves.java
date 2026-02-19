import java.util.*;
//  n*n 그리드
// 두 도둑은 각각 하나의 행을 정해 M개의 열을 각각 훔칠 수 있음
// 두 도둑이 같은 행을 고르면 M개의 열이 겹치면 안됨
// 선택한 연속한 M개의 열에 있는 물건들의 무게의 합이 C를 넘지 않도록 가져가야 함.
// 무게가 W인 물건으로 부터 얻을 수 있는 가치는 W^2
// 도둑들이 훔칠 물건들을 잘 골라 조건을 만족하면서 가치의 총 합 중 최대값을 구하시오.
class Pair {
    int r;
    int c;

    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
public class Main {
    static int n, m, c;
    static int ans, best;
    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= n- m; j++) {
                ArrayList<Pair> cur = new ArrayList<>();
                for(int t = 0; t < m; t++) {
                    cur.add(new Pair(i, j + t));
                }

                int value = findMaxValue(cur, i, j);
                ans = Math.max(ans, value);
            }
        }
        
        System.out.println(ans);
    }

    static int findMaxValue(List<Pair> cur, int row, int col) {        
        int maxValue = Integer.MIN_VALUE;
        int curVal = calc(cur);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= n - m; j++) {
                if(i == row && isDuplicated(j, col)) continue;
                
                ArrayList<Pair> tmp = new ArrayList<>();
                for(int k = 0; k < m; k++) {
                    tmp.add(new Pair(i, j + k));
                }

                maxValue = Math.max(maxValue, curVal + calc(tmp));
            }
        }

        return maxValue;
    }

    static boolean isDuplicated(int c1, int c2) {
        if(!(c1 + m - 1 < c2 || c2 + m - 1 < c1)) return true;
        return false;
    }

    static int calc(List<Pair> pairs) {
        int[] w = new int[m];
        for(int i = 0; i < m; i++) {
            Pair p = pairs.get(i);
            w[i] = grid[p.r][p.c];
        }

        best = 0;
        dfsSubset(w, 0, 0, 0);
        return best;
    }

    static void dfsSubset(int[] w, int idx, int sumW, int sumV) {
        if(sumW > c) return;
        if(idx == m) {
            best = Math.max(best, sumV);
            return;
        }

        dfsSubset(w, idx + 1, sumW, sumV);

        int ww = w[idx];
        dfsSubset(w, idx + 1, sumW + ww, sumV + ww*ww);
    }
}