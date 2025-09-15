import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MAX_VALUE;
        int tmp;
        for(int i = 0; i < n; i++) {
            tmp = 0;
            for(int j = 0; j < n; j++) {
                if(j == i) continue;
                tmp += Math.abs(j - i) * a[j];
            }
            ans = Math.min(tmp, ans);
        }

        System.out.println(ans);
    }
}