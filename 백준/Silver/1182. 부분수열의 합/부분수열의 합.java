import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int S;
    private static int answer = 0;
    private static ArrayList<Integer> arr = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);



        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());


        s = br.readLine();
        st = new StringTokenizer(s);

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        dfs(0, 0);
        if (S == 0) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }

    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                answer ++;
            }
            return;
        }
        dfs(depth + 1, sum + arr.get(depth));
        dfs(depth + 1, sum);
    }
}