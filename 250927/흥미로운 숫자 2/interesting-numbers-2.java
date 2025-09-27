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
            int allDigits = 0;
            while(num > 0) {
                int digit = num % 10;
                arr[digit]++;
                allDigits++;
                num /= 10;
            }

            boolean flag = false;

            for(int j = 0; j < 10; j++) {
                if(arr[j] == allDigits - 1) flag = true;
            }

            if(flag) ans++;
        }

        System.out.println(ans);
    }
}