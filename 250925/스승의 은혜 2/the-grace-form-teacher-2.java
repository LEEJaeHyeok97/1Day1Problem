import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        // Please write your code here.
        Arrays.sort(p);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            p[i] /= 2;
            int tmp = 0; int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(p[j] + tmp > b) break;
                tmp += p[j];
                cnt++;
            }
            p[i] *= 2;
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}