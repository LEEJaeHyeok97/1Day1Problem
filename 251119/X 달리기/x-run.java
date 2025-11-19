import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        // Please write your code here.
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= x; i++) {
            int cur_speed = 1;
            int cur_pos = 0;
            boolean flag = false;
            for(int j = 1; j < x; j++) {
                cur_pos += cur_speed;

                if(i == j) flag = true;
                if(flag) {
                    if(cur_speed > 1) cur_speed--;
                } else {
                    cur_speed++;
                }

                if(cur_pos >= x && cur_speed == 1) {
                    ans = Math.min(ans, j);
                }
                
            }
        }

        System.out.println(ans);
    }
}