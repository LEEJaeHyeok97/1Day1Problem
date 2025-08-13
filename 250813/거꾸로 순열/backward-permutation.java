import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int N;
    static boolean[] visited;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];

        dfs(0);
    }

    static void dfs(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = N; i > 0; i--) {
            if (visited[i]) continue;
            visited[i] = true;
            arr.add(i);

            dfs(cnt + 1);

            visited[i] = false;
            arr.remove(arr.size() - 1);
        }
    }
}
