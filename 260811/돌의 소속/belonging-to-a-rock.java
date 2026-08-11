import java.util.Scanner;

// 1~N N개의 돌. 각 돌은 1, 2, 3 중 하나에 무조건 속한다.
// q개의 돌 번호 범위마다 각 그룹의 돌이 몇 개씩 있는지 구하는 프로그램을 작성.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] stones = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stones[i] = sc.nextInt();
        }

        int[][] prefixSum = new int[3][n + 1];
        for(int i = 1; i <= n; i++) {
            if(stones[i] == 1) {
                prefixSum[0][i] = prefixSum[0][i-1] + 1;
            } else {
                prefixSum[0][i] = prefixSum[0][i-1];
            }
            if(stones[i] == 2) {
                prefixSum[1][i] = prefixSum[1][i-1] + 1;
            } else {
                prefixSum[1][i] = prefixSum[1][i-1];
            }
            if(stones[i] == 3) {
                prefixSum[2][i] = prefixSum[2][i-1] + 1;
            } else {
                prefixSum[2][i] = prefixSum[2][i-1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            for(int j = 0; j < 3; j++) {
                int tmp = prefixSum[j][r] - prefixSum[j][l-1];
                sb.append(tmp + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}