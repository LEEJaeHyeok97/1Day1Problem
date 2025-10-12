import java.util.Scanner;

public class Main {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String seat = sc.next();
        // Please write your code here.
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(seat.charAt(i) == '1' || seat.charAt(j) == '1')
                    continue;
                StringBuilder sb = new StringBuilder(seat);
                sb.setCharAt(i, '1');
                sb.setCharAt(j, '1');
                String cand = sb.toString();

                ans = Math.max(ans, checkMinDistance(cand));
            }
        }

        System.out.println(ans);
    }

    static int checkMinDistance(String s) {
        int prev = -1;
        int best = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') {
                if(prev != -1) best = Math.min(best, i - prev);
                prev = i;
            }
        }

        return best;
    }
}