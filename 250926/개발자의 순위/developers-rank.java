import java.util.Scanner;

// K번의 경기에 대해 N명의 개발자의 순위가 주어졌을 때
// 항상 a번 개발자가 b번 개발자보다 높은 순위였던 (a,b) 쌍을 구하는 프로그램
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            int[] tmp = new int[n+1];
            for(int j = 0; j < k; j++) {
                boolean flag = false;
                for(int s = 0; s < n; s++) {
                    if(arr[j][s] == i) flag = true;
                    if(flag) {
                        tmp[arr[j][s]]++;
                    }
                }
            }

            for(int j = 1; j <= n; j++) {
                if(i == j) continue;
                if(tmp[j] == k) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}