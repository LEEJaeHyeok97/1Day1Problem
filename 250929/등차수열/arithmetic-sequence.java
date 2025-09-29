import java.util.Scanner;

public class Main {
    static final int MAX_A = 100;
    static final int MAX_N = 100;
    
    static int n;
    static int[] arr = new int[MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = 0;

        for(int x = 1; x <= MAX_A; x++) {
            int cnt = 0;

            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    if(arr[i] + arr[j] == 2 * x)
                        cnt++;
                }
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}