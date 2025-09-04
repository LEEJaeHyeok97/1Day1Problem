import java.util.Scanner;

public class Main {
    static final int OFFSET = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt() + OFFSET;
        int rect1_y1 = sc.nextInt() + OFFSET;
        int rect1_x2 = sc.nextInt() + OFFSET;
        int rect1_y2 = sc.nextInt() + OFFSET;

        int rect2_x1 = sc.nextInt() + OFFSET;
        int rect2_y1 = sc.nextInt() + OFFSET;
        int rect2_x2 = sc.nextInt() + OFFSET;
        int rect2_y2 = sc.nextInt() + OFFSET;
        // Please write your code here.
        int [][] arr = new int[2001][2001];
        for (int i = rect1_x1; i < rect1_x2; i++) {
            for (int j = rect1_y1; j < rect1_y2; j++) {
                arr[i][j] = 1;
            }
        }

        for (int i = rect2_x1; i < rect2_x2; i++) {
            for (int j = rect2_y1; j < rect2_y2; j++) {
                arr[i][j] = 0;
            }
        }

        int min_x1 = 2002;
        int min_y1 = 2002;
        int max_x1 = 0;
        int max_y1 = 0;

        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if (arr[i][j] == 1) {
                    if (i < min_x1) {
                        min_x1 = i;
                    }
                    if (j < min_y1) {
                        min_y1 = j;
                    }

                    if (i > max_x1) {
                        max_x1 = i;
                    }
                    if (j > max_y1) {
                        max_y1 = j;
                    }
                }
            }
        }
        
        for (int i = min_x1; i <= max_x1; i++) {
            for (int j = min_y1; j <= max_y1; j++) {
                arr[i][j] = 1;
            }
        }

        int answer = 0;
        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                if (arr[i][j] == 1) answer +=1;
            }
        }

        System.out.println(answer);
        
    }
}