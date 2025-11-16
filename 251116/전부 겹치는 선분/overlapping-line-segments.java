import java.util.Scanner;
public class Main {

    static int[] arr = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int cnt = 1;
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            boolean flag = false;
            for(int j = a; j < b+1; j++) {
                if(arr[j] == 1) {
                    flag = true;
                }
                arr[j] = 1;
            }
            if(flag) cnt++;
        }

        if(cnt == n) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }
}