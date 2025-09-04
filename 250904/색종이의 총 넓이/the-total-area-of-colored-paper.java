import java.util.Scanner;
public class Main {
    static final int OFFSET = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt() + OFFSET;
            y[i] = sc.nextInt() + OFFSET;
        }
        // Please write your code here.
        int[][] arr = new int[201][201];

        for (int di = 0; di < n; di++) {
            for (int i = x[di]; i < x[di] + 8; i++) {
                for (int j = y[di]; j < y[di] + 8; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (arr[i][j] == 1) {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}