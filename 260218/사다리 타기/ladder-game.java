import java.util.*;

// 세로줄 사이에 가로줄 M개를 겹치지 않게 긋는다.
// 끝에 도착하면 해당 숫자를 적는 게임
// 사용한 가로줄을 적절하게 선택해 모든 가로줄을 이용했을 때와 동일하게 되도록 하는
// 최소 가로줄의 수를 구하는 프로그램을 작성.
class Line {
    int col;
    int row;

    public Line(int col, int row) {
        this.col = col;
        this.row = row;
    }
}

public class Main {

    static int n, m;
    static ArrayList<Line> selected = new ArrayList<>();

    static ArrayList<Line> lines = new ArrayList<>();

    static int[] res;
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            lines.add(new Line(b, a));
        }

        lines.sort(Comparator.comparint((Line l) -> l.row).thenComparingInt(l -> l.col));
        res = simulate(lines);

        ans = m;
        selectLine(0);

        System.out.println(ans);
    }

    static void selectLine(int cnt) {
        if(isMatch(calc())) {
            ans = Math.min(ans, selected.size());
            return;
        }

        for(int i = cnt; i < lines.size(); i++) {
            selected.add(lines.get(i));
            selectLine(i + 1);
            selected.remove(selected.size() - 1);
        }
    }

    static int[] calc() {
        return simulate(selected);
    }

    static int[] simulate(List<Line> use) {
        int[] pos = new int[n+1];
        for(int i = 1; i <= n; i++) pos[i] = i;

        for(Line ln : use) {
            int c = ln.col;
            int tmp = pos[c];
            pos[c] = pos[c+1];
            pos[c+1] = tmp;
        }

        return pos;
    }

    static boolean isMatch(int[] input) {
        for(int i = 0; i < n; i++) {
            if(input[i] != res[i]) {
                return false;
            }
        }

        return true;
    }
}