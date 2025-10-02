import java.util.Scanner;
public class Main {
    static final int MAX_X = 9;
    static final int MAX_A = 3;

    static String[] inp = new String[MAX_A];
    static int[][] board = new int[MAX_A][MAX_A];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < MAX_A; i++) {
            inp[i] = sc.next();
        }
        
        for(int i = 0; i < MAX_A; i++) {
            for(int j = 0; j < MAX_A; j++) {
                board[i][j] = inp[i].charAt(j) - '0';
            }
        }

        int ans = 0;
        for(int i = 1; i <= MAX_X; i++) {
            for(int j = i + 1; j <= MAX_X; j++) {
                boolean win = false;

                int numI = 0, numJ = 0;

                for(int k = 0; k < MAX_A; k++) {
                    numI = 0;
                    numJ = 0;
                    for(int l = 0; l < MAX_A; l++) {
                        if(board[k][l] == i)
                            numI++;
                        if(board[k][l] == j)
                            numJ++;
                    }

                    if(numI + numJ == 3 && numI >= 1 && numJ >= 1)
                        win = true;
                }

                for(int k = 0; k < MAX_A; k++) {
                    numI = 0;
                    numJ = 0;
                    for(int l = 0; l < MAX_A; l++) {
                        if(board[l][k] == i)
                            numI++;
                        if(board[l][k] == j)
                            numJ++;
                    }

                    if(numI + numJ == 3&& numI >= 1 && numJ >= 1)
                        win = true;
                }

                numI = 0; numJ = 0;
                for(int k = 0; k < MAX_A; k++) {
                    if(board[k][k] == i)
                        numI++;
                    if(board[k][k] == j)
                        numJ++;
                }

                if(numI + numJ == 3&& numI >= 1 && numJ >= 1)
                    win = true;

                numI = 0; numJ = 0;
                for(int k = 0; k < MAX_A; k++) {
                    if(board[k][MAX_A - k - 1] == i)
                        numI++;
                    if(board[k][MAX_A - k - 1] == j)
                        numJ++;
                }

                if(numI + numJ == 3&& numI >= 1 && numJ >= 1)
                    win = true;



                if(win) ans++;

            }
        }

        System.out.println(ans);
    }
}