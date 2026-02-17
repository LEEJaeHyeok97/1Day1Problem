import java.util.*;

// 수직선상에 N개의 선분이 주어졌을 때, 서로 겹치지 않고 고를 수 있는 가장 많은 선분의 수를 구하시오
// 끝점을 공유하는 것 역시 겹친 것으로 생각.
class Line {
    int l;
    int r;

    public Line(int l, int r) {
        this.l = l;
        this.r = r;
    }
}

public class Main {

    static int ans;
    static ArrayList<Line> selectedLine = new ArrayList<>();
    static int[][] segments;

    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new int[n][2]; // n개의 선분의 양 끝점을 저장.
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }

        selectLine(0);

        System.out.println(ans);
    }

    int selectedCnt = 1;
    static void selectLine(int selectedCnt) {
        ans = Math.max(ans, selectedLine.size());

        for(int i = 0; i < segments.length; i++) {
            int left = segments[i][0];
            int right = segments[i][1];

            if(!isDuplicate(left, right)) {
                selectedLine.add(new Line(left, right));
                selectLine(i + 1);
                selectedLine.remove(selectedLine.size() - 1);
            }
        }
    }

    static boolean isDuplicate(int left, int right) {
        for(int i = 0; i < selectedLine.size(); i++) {
            Line line = selectedLine.get(i);

            if(!(line.r < left || line.l > right)) return true;
        }

        return false;
    }
}