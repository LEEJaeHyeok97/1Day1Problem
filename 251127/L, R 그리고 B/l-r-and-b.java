import java.util.Scanner;
public class Main {
    static final int MAX_N = 10;

    static int n = 10;

    static String[] board = new String[MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < n; i++) {
            board[i] = sc.next();
        }
        // Please write your code here.
        int lX = 0, lY = 0, rX = 0, rY = 0, bX = 0, bY =0;

        for(int i =0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i].charAt(j) == 'L') {
                    lX = i; lY = j;
                }

                if(board[i].charAt(j) == 'R') {
                    rX = i; rY = j;
                }

                if(board[i].charAt(j) == 'B') {
                    bX = i; bY = j;
                }
            }
        }

        if(lX != bX && lY != bY) {
            System.out.println(Math.abs(lX - bX) + Math.abs(lY - bY) - 1);
        } 

        // 가로 방향 일직선
        if(lX == bX && lY != bY) {
            System.out.println(Math.abs(lY - bY) - 1);
        }

        // 세로 방향 일직선
        if(lX != bX && lY == bY) {
            System.out.println(Math.abs(lX - bX) - 1);
        }
    }
}