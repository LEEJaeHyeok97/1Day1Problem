import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            int[] counting = new int[1001];
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                for(int k = A[j]; k < B[j]; k++) {
                    counting[k]++;
                }

            }
            int tmp = 0;
                for(int k = 0; k < 1001; k++) {
                    if(counting[k]>0) {
                        tmp++;
                    }
                }
            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }
}