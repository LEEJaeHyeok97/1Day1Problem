import java.util.Scanner;

public class Main {

    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        grid = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        char dir = sc.next().charAt(0);
        // Please write your code here.
        gravityMove(dir);
        gravitySum(dir);
        gravityMove(dir);

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void gravityMove(char d) { // 옮기기
        if(d == 'L') {
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    int idx = 1;
                    while(inRange(i, j - idx)) {
                        if(grid[i][j - idx] == 0) {
                            grid[i][j - idx] = grid[i][j - idx + 1];
                            grid[i][j - idx + 1] = 0;
                        }
                        idx+= 1;
                    }
                }
            }
        }

        if(d == 'R') {
            for(int i = 0; i < 4; i++) {
                for(int j = 3; j >= 0; j--) {
                    int idx = 1;
                    while(inRange(i, j + idx)) {
                        if(grid[i][j + idx] == 0) {
                            grid[i][j + idx] = grid[i][j + idx - 1];
                            grid[i][j + idx - 1] = 0;
                        }
                        idx+=1;
                    }
                }
            }
        }

        if(d == 'U') {
            for(int j = 0; j < 4; j++) {
                for(int i = 0; i < 4; i++) {
                    int idx = 1;
                    while(inRange(i + idx, j)) {
                        if(grid[i + idx][j] == 0) {
                            grid[i + idx][j] = grid[i + idx - 1][j];
                            grid[i + idx - 1][j] = 0;
                        }
                        idx+=1;
                    }
                }
            }
        }

        if(d == 'D') {
            for(int j = 0; j < 4; j++) {
                for(int i = 3; j >= 0; j++) {
                    int idx = 1;
                    while(inRange(i + idx, j)) {
                        if(grid[i - idx][j] == 0) {
                            grid[i - idx][j] = grid[i - idx + 1][j];
                            grid[i - idx + 1][j] = 0;
                        }
                        idx+=1;
                    }
                }
            }
        }
    }

    static void gravitySum(char d) { // 합치기
        if(d == 'L') {
            for(int i = 0; i < 4; i++) {
                int prev = -1;
                for(int j = 0; j < 4; j++) {
                    if(prev == grid[i][j]) {
                        grid[i][j] = grid[i][j] * 2;
                        grid[i][j - 1] = 0;
                        prev = -1;
                        continue;
                    }

                    prev = grid[i][j];
                }
            }
        }

        if(d == 'R') {
            for(int i = 0; i < 4; i++) {
                    int prev = -1;
                for(int j = 3; j >= 0; j--) {
                    if(prev == grid[i][j]) {
                        grid[i][j] *= 2;
                        grid[i][j + 1] = 0;
                        prev = -1;
                        continue;
                    }

                    prev = grid[i][j];
                }
            }
        }

        if(d == 'U') {
            for(int j = 0; j < 4; j++) {
                int prev = -1;
                for(int i = 0; i < 4; i++) {
                    if(prev == grid[i][j]) {
                        grid[i][j] *= 2;
                        grid[i - 1][j] = 0;
                        prev = -1;
                        continue;
                    }

                    prev = grid[i][j];
                }
            }
        }

        if(d == 'D') {
            for(int j = 0; j < 4; j++) {
                int prev = -1;
                for(int i = 3; i >= 0; i++) {
                    if(prev == grid[i][j]) {
                        grid[i][j] *= 2;
                        grid[i + 1][j] = 0;
                        prev = -1;
                        continue;
                    }

                    prev = grid[i][j];
                }
            }
        }
    }

    static boolean inRange(int i, int j) {
        if((i >= 0 && i < 4) && (j >= 0 && j < 4)) return true;

        return false;
    }
}