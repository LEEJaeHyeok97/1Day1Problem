import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String N = sc.next();
        // Please write your code here.
        
        int num = 0;
        for(int i = 0; i < N.length(); i++) {
            num = num * A + Integer.parseInt(String.valueOf(N.charAt(i)));
        }

        // System.out.println(num);

        int[] arr = new int[num];
        int cnt = 0;
        while(true) {
            if (num < B) {
                arr[cnt] = num;
                break;
            }

            arr[cnt++] = num % B;
            num /= B;
        }

        for(int i = cnt; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
}