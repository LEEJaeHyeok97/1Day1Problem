import java.util.*;

// n * n 격자 정수값이 적혀 있다.
// n개의 칸에 색칠 하여 각 행과 열에 정확히 1개의 색칠된 칸만 오도록 하려고 한다.
// 색칠된 칸에 적힌 수들 중 최솟값이 최대가 되도록 하는 프로그램
public class Main {

    static int n;
    static int[][] grid;
    static boolean[] visited;
    static int ans = Integer.MIN_VALUE;

    static ArrayList<Integer> selected = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        visited = new boolean[n];
        choose(1);

        System.out.println(ans);
    }

    static void choose(int curNum) {
        if(curNum == n + 1) {
            ans = Math.max(ans, calc());
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
            selected.add(i);
            visited[i] = true;
            choose(curNum + 1);

            selected.remove(selected.size() - 1);
            visited[i] = false;
            }
        }
    }

    static int calc() {
        int tmp = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            // tmp += grid[i][selected.get(i)];
            tmp = Math.min(tmp, grid[i][selected.get(i)]);
        }

        return tmp;
    }
}