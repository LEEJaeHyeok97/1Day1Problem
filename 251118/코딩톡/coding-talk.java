import java.util.*;
public class Main {
    static Character[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
    'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int p = sc.nextInt();
        arr = new int[N];
        char[] c = new char[M];
        int[] u = new int[M];
        for (int i = 0; i < M; i++) {
            c[i] = sc.next().charAt(0);
            u[i] = sc.nextInt();
            if(i + 1 >= p) {
                arr[Arrays.asList(alpha).indexOf(c[i])]++;
            }
        }
        // Please write your code here.
        for(int i = 0; i < N; i++) {
            if(arr[i] == 0) {
                System.out.print(alpha[i] + " ");
            }
        }
    }
}