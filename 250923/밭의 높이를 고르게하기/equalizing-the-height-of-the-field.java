import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 연속 최소 T번 이상 H높이로 나오는 최소 비용
        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - t; i++) {
            int cnt = 0;
            for(int j = i; j < i + t; j++) {
                int tmp = arr[j];
                while(tmp != h) {
                    if(tmp > h) {
                        tmp--;
                        cnt++;
                    } else if(tmp < h) {
                        tmp++;
                        cnt++;
                    }
                }
            }
            ans = Math.min(ans, cnt);
        }

        System.out.println(ans);
    }
}