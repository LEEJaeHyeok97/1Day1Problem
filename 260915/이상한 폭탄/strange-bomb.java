import java.util.*;

// 이상한 폭탄 N개. 같은 번호가 부여된 폭탄끼리 거리가 K 안에 있다면 폭발.
// 폭발할 폭탄 중 부여된 번호가 가장 큰 번호를 출력
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 전처리
        int[] last = new int[1_000_001];
        Arrays.fill(last, -1);

        // 완탐
        int ans = -1;
        for(int i = 0; i < n; i++) {
            int x = arr[i];

            if(last[x] != -1 && i - last[x] <= k) {
                ans = Math.max(ans, x);
            }
            last[x] = i;
        }

        System.out.println(ans);
    }
}