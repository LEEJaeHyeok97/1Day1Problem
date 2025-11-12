import java.util.Scanner;
public class Main {
    static final int MAX_N = 1000;
    
    static int n, l;
    static int[] a = new int[MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        // Please write your code here.

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            int cntl = 0;

            for(int j = 0; j < n; j++) {
                if(a[j] >= i)
                    cnt++;
                else if (a[j] == i - 1) {
                    if(cntl < l) {
                        cntl++;
                        cnt++;
                    }
                }
            }

            if(cnt >= i)
                ans = i;
        }

        System.out.println(ans);
    }
}