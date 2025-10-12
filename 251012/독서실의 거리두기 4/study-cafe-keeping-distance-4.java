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
            for(int j = 0; j < n; j++) {
                if(seat.charAt(i) == '1' || seat.charAt(j) == '1')
                    continue;
                StringBuilder sb = new StringBuilder(seat);
                sb.setCharAt(i, '1');
                sb.setCharAt(j, '1');

                seat = sb.toString();
                ans = Math.max(ans, checkMinDistance(seat));


                sb = new StringBuilder(seat);
                sb.setCharAt(i, '0');
                sb.setCharAt(j, '0');
                seat = sb.toString();
            }
        }

        System.out.println(ans);
    }

    static int checkMinDistance(String seat) {
        int distance = Integer.MAX_VALUE;
        int prev = 0;
        int tmp = 0;
        for(int i = 1; i < n; i++) {
            if(seat.charAt(i) == '1' && seat.charAt(prev) == '1') {
                distance = Math.min(distance, i - prev);
            }
            if(seat.charAt(i) == '1') prev = i;
        }

        return distance;
    }
}