import java.util.Scanner;

// 폭탄N개 같은 번호가 부여된 폭탄끼리 거리가 K면 폭발
// 폭발할 폭탄 중 번호가 가장 큰 번호를 출력
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] bombs = new int[n];
        for (int i = 0; i < n; i++) {
            bombs[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j = i + 1; j < n; j++) {
                if(cnt <= k && bombs[j] == bombs[i]) {
                    ans = Math.max(ans, bombs[i]);
                    break;
                }
                else {
                    cnt++;
                }
            }
        }

        if(ans == Integer.MIN_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}