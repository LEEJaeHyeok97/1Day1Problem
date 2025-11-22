import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String seats = sc.next();
        // Please write your code here.
        char[] arr = seats.toCharArray();
        // System.out.println(arr);
        boolean flag = false;
        int tmpStart = 0;
        int spot = 0;
        int maxDistance = 0;
        int cnt = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '1' && !flag) {
                flag = true;
                tmpStart = i;
                cnt = 0;
            } else if(arr[i] == '1' && flag) {
                flag = false;
                if(cnt > maxDistance) {
                    maxDistance = cnt;
                    cnt = 0;
                    spot = (i + tmpStart) / 2;
                    // System.out.print(spot);
                }
                // mid = tmpStart + (i + tmpStart) / 2;
                // System.out.println(mid);
            }

            cnt++;
        }

        arr[spot] = '1';
        int ans = Integer.MAX_VALUE;
        cnt = 0;
        flag = false;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '1' && !flag) {
                flag = true;
                cnt = 0;
                continue;
            }
            cnt++;
            
            if(arr[i] == '1' && flag) {
                ans = Math.min(ans, cnt);
                cnt = 0;
            }
            // System.out.print(arr[i]);
        }

        System.out.println(ans);
    }
}