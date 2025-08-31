import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.

        int[] arr = new int[n/2];

        int cnt = 1;
        while (true) {
            if (n < 2) {
                arr[cnt] = n;
                break;
            }
            
            arr[cnt++] = n % 2;
            n /= 2;
        }

        for(int i = cnt; i >= 1; i--) {
            System.out.print(arr[i]);
        }
    }
}