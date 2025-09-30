import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
        }
        // Please write your code here.
        boolean[] arr = new boolean[4];
        int ans = 0;
        for(int i = 1; i <= 3; i++) {
            arr = new boolean[4];
            arr[i] = true;
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                boolean tmp = false;
                tmp = arr[a[j]];
                arr[a[j]] = arr[b[j]];
                arr[b[j]] = tmp;

                if(arr[c[j]] == true) cnt++;
            }

            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}