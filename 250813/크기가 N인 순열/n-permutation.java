import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final int MAX_N = 8;

    static int N;
    static boolean[] visited = new boolean[MAX_N + 1];
    static ArrayList<Integer> picked = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dfs(0);
    }

    static void dfs(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < picked.size(); i++) {
                System.out.print(picked.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            picked.add(i);
            dfs(cnt + 1);
            visited[i] = false;
            picked.remove(picked.size() - 1);
        }
    }
}
