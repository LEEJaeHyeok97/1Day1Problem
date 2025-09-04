import java.util.*;
public class Main {
    static final int OFFSET = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[201][201];
        int cur_color = 1; // 1: Red, 2:Blue
        for (int ki = 0; ki < n; ki++) {
            int x1 = sc.nextInt() + OFFSET;
            int y1 = sc.nextInt() + OFFSET;
            int x2 = sc.nextInt() + OFFSET;
            int y2 = sc.nextInt() + OFFSET;
            
                for (int i = x1; i < x2; i++) {
                    for (int j = y1; j < y2; j++) {
                        arr[i][j] = cur_color;
                    }
                }
            
            cur_color += 1;
            if (cur_color == 3) cur_color = 1;
        }
        // Please write your code here.

        int answer = 0;
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (arr[i][j] == 2) answer +=1;
            }
        }
        System.out.println(answer);
    }
}