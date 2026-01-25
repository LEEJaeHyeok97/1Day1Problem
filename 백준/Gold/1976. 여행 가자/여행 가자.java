import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] tokens = input.split(" ");

            int tmp = 0;
            for (String token : tokens) {
                if (token.equals("1")) {
                    union(i + 1, tmp + 1);
                }

                tmp++;
            }
        }

        String tokens = br.readLine();
        String[] splittedTokens = tokens.split(" ");
        int firstNodeRootNumber = find(Integer.parseInt(splittedTokens[0]));
        for (int i = 1; i < splittedTokens.length; i++) {
            if (firstNodeRootNumber != find(Integer.parseInt(splittedTokens[i]))) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    public static boolean union(int a, int b) {
        int A = find(a);
        int B = find(b);

        if (A == B) return false;

        if(A <= B) arr[B] = A;
        else arr[A] = B;

        return true;
    }

    public static int find(int a) {
        if (arr[a] == a) {
            return a;
        }

        return find(arr[a]);
    }
}
