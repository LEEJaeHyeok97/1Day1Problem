import java.util.Scanner;
public class Main {
    static final int OFFSET = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt() + OFFSET;
        int ay1 = sc.nextInt() + OFFSET;
        int ax2 = sc.nextInt() + OFFSET;
        int ay2 = sc.nextInt() + OFFSET;
        int bx1 = sc.nextInt() + OFFSET;
        int by1 = sc.nextInt() + OFFSET;
        int bx2 = sc.nextInt() + OFFSET;
        int by2 = sc.nextInt() + OFFSET;
        int mx1 = sc.nextInt() + OFFSET;
        int my1 = sc.nextInt() + OFFSET;
        int mx2 = sc.nextInt() + OFFSET;
        int my2 = sc.nextInt() + OFFSET;
        // Please write your code here.
        int[][] arr = new int[2001][2001];
        for (int i = ax1; i < ax2; i++) {
            for (int j = ay1; j < ay2; j++) {
                arr[i][j] = 1;
            }
        }

        for (int i = bx1; i < bx2; i++) {
            for (int j = by1; j < by2; j++) {
                arr[i][j] = 1;
            }
        }

        for (int i = mx1; i < mx2; i++) {
            for (int j = my1; j < my2; j++) {
                arr[i][j] = 0;
            }
        }

        int answer = 0;
        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if (arr[i][j] == 1) {
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}