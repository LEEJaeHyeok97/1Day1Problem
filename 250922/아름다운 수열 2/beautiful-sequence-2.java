import java.util.*;
public class Main {
    static final int MAX_N = 100;

    static int[] tmp = new int[MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++)
            B[i] = sc.nextInt();
        // Please write your code here.
        Arrays.sort(B, 0, M);

        int cnt = 0;
        for(int i = 0; i <= N - M; i++) {
            for(int j = 0; j < M; j++) {
                tmp[j] = A[i+j];
            }
            Arrays.sort(tmp, 0, M);

            boolean issame = true;
            for(int j = 0; j < M; j++) {
                if(tmp[j] != B[j]) {
                    issame = false;
                    break;
                }
            }

            if(issame) cnt++;
        }
        System.out.println(cnt);
    }
}