import java.util.Scanner;

// 1차원 직선위에 N개의 바구니, [c-k, c+k] 사탕의 수가 최대가 되도록
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] candyCount = new int[1000001];
        for (int i = 0; i < n; i++) {
            int candy = sc.nextInt();
            int position = sc.nextInt();

            candyCount[position] += candy;
        }

        int j = 1;
        int ans = Integer.MIN_VALUE;
        int sumVal = candyCount[0];
        for(int i = 0; i < 1000001; i++) {
            while(j < 1000001 && j - i != 2*k + 1) {
                sumVal += candyCount[j];
                j++;
            }
            ans = Math.max(ans, sumVal);
            sumVal -= candyCount[i];
        }

        System.out.println(ans);
    }
}