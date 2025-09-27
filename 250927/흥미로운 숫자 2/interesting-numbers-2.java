import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        // Please write your code here.
        int ans = 0;
        
        for(int i = x; i <= y; i++) {
            int[] arr = new int[10];
            
            int num = i;
            while(num > 0) {
                int digit = num % 10;
                arr[digit]++;
                num /= 10;
            }

            int cnt = 0;
            for(int j = 0; j < 10; j++) {
                if(arr[j] > 0) cnt++;
            }

            if(cnt == 2) ans++;
        }

        System.out.println(ans);
    }
}