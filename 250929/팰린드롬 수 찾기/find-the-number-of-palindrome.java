import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        // Please write your code here.
        int ans = 0;
        for(int i = x; i <= y; i++) {
            int l = 1;
            for(int j = 0; j < String.valueOf(i).length() - 1; j++) l *= 10;
            int r = 1;

            boolean flag = false;
            while (l > r) {
                int leftDigit = (i/l) % 10;
                int rightDigit = (i/r) % 10;

                if(leftDigit != rightDigit) {
                    flag = true;
                    break;
                }

                l /= 10;
                r *= 10;
            }

            if(flag) continue;
            // System.out.println(i);
            ans++;
        }

        System.out.println(ans);
    }
}