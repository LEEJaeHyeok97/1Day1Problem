import java.util.Scanner;
// 최대한 거리를 두면서 자리배치
// 가장 가까운 두 사람 간의 거리를 최대로
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String seats = sc.next();
        char[] seat = seats.toCharArray();
        // Please write your code here.
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(seat[i] == '1') continue;

            seat[i] = '1';
            int cnt = 0;
            int tmp = Integer.MAX_VALUE;
            boolean flag = false;
            for(int j = 0; j < n; j++) {
                cnt++;
                if(seat[j] == '1' && flag == false) {
                    flag = true;
                    cnt = 0;
                } else if(seat[j] == '1') {
                    tmp = Math.min(tmp, cnt);
                    cnt = 0;
                }
            }

            ans = Math.max(ans, tmp);
            seat[i] = '0';
        }

        System.out.println(ans);
    }
}