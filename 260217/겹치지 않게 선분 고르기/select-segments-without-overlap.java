import java.util.*;

class Pair {
    int left;
    int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
public class Main {

    static int n, ans;
    static ArrayList<Pair> selected = new ArrayList<>();
    static int[][] segments;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }
        
        selectSegments(0);

        System.out.println(ans);
    }

    static void selectSegments(int cnt) {
        ans = Math.max(ans, selected.size());

        for(int i = cnt; i < n; i++) {
            int left = segments[i][0];
            int right = segments[i][1];
            if(!isMeet(left, right)) {
                selected.add(new Pair(left, right));
                selectSegments(cnt + 1);
                selected.remove(selected.size() - 1);
            }
        }
    }

    static boolean isMeet(int left, int right) {
        for(int i = 0; i < selected.size(); i++) {
            Pair pair = selected.get(i);
            if(!((pair.left > right) || (pair.right < left))) {
                return true;
            }
        }

        return false;
    }
}