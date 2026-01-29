import java.util.Scanner;

public class Main {

    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    for(int s = k; s < m; s++) {
                        for(int i2 = 0; i2 < n; i2++) {
                            for(int j2 = i2; j2 < n; j2++) {
                                for(int k2 = 0; k2 < m; k2++) {
                                    for(int s2 = k2; s2 < m; s2++) {
                                        if(isDiff(i, j, k, s, i2, j2, k2, s2)) {
                                            int tmpTotal = 0;
                                            tmpTotal = calculateSum(i, j, k, s) + calculateSum(i2, j2, k2, s2);

                                            ans = Math.max(ans, tmpTotal);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static int calculateSum(int a, int b, int c, int d) {
        int total = 0;
        for(int i = a; i < b + 1; i++) {
            for(int j = c; j < d + 1; j++) {
                total += grid[i][j];
            }
        }

        return total;
    }

    static boolean isDiff(int a, int b, int c, int d, int a2, int b2, int c2, int d2) {
        // A 가 B의 완전 왼쪽
        if(d < c2) return true;

        // A 가 B의 완전 오른쪽
        if(d2 < c) return true;

        // A가 B의 완전 위쪽
        if(b < a2) return true;

        //A가 B의 완전 아래쪽
        if(a > b2) return true;

        return false;
    } 
}