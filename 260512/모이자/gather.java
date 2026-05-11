import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int tmp = 0;
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                else {
                    tmp += a[j]*(Math.abs(i-j));
                }
            }

            ans = Math.min(ans, tmp);
        }

        System.out.println(ans);
    }
}