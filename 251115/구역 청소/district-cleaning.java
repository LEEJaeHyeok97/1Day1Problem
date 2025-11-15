import java.util.Scanner;
public class Main {
    
    static int[] arr = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.
        for(int i = a; i < b; i++) {
            arr[i] = 1;
        }
        for(int i = c; i < d; i++) {
            arr[i] = 1;
        }

        int ans = 0;
        for(int i = 0; i < 101; i++) {
            if(arr[i] == 1) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}