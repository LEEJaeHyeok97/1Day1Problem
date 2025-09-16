import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        // Please write your code here.
        int ans = 0;
        for(int i = 1; i < R -2 ; i++) {
            for(int j = 1; j < C - 2; j++) {
                for(int k = i + 1; k < R - 1; k++) {
                    for(int s = j + 1; s < C -1; s++) {
                        if(grid[i][j] != grid[0][0] && grid[k][s] != grid[i][j])
                            ans += 1;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}