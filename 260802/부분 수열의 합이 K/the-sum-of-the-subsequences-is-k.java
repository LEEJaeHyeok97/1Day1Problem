import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j <= n - i; j++) {
                int tmp = 0;
                for(int s = 0; s < i; s++) {
                    tmp += arr[s];
                }
                if(tmp == k) ans++;
            }
        }

        System.out.println(ans);
    }
}