import java.util.Scanner;
public class Main {
    static final int OFFSET = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt() + OFFSET;
            y1[i] = sc.nextInt() + OFFSET;
            x2[i] = sc.nextInt() + OFFSET;
            y2[i] = sc.nextInt() + OFFSET;
        }
        // Please write your code here.
        int[][] arr = new int[201][201];
        for (int di = 0; di < n; di++) {
            for (int i = x1[di]; i < x2[di]; i++) {
                for (int j = y1[di]; j < y2[di]; j++) {
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