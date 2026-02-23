import java.util.*;
// n개의 정수는 각 위치로부터 최대 점프 가능 거리
// 첫 번째 위치로부터 N번째 위치에 도달하기 위해 필요한 최소 점프 횟수 출력(불가능 시: -1)
public class Main {

    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[] arr;
    static int curIdx = 0;

    static ArrayList<Integer> selected = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        selected.add(0);
        backtracking(0);
        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }

    static void backtracking(int cnt) {
        if(cnt == n + 1) return;
        if(isGoal()) {
            // System.out.println(cnt);
            // System.out.println(ans);
            // System.out.println("===");
            ans = Math.min(ans, cnt);
            return;
        }

        for(int i = curIdx + 1; i < n; i++) {
            if(inJumpRange(curIdx, i)) {
                selected.add(i);
                curIdx = i;
                backtracking(cnt + 1);
                selected.remove(selected.size() - 1);
                curIdx = selected.get(selected.size() - 1);
            } else {
                continue;
            }
        }
    }

    static boolean inJumpRange(int curIdx, int toIdx) {
        if(curIdx + arr[curIdx] >= toIdx) return true;
        return false;
    }

    static boolean isGoal() {
        if(selected.get(selected.size() - 1) == n - 1) return true;
        return false;
    }
}