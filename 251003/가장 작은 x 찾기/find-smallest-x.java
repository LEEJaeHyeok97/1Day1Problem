import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        // Please write your code here.
        for(int i = 1; i <= 10000; i++) {
            long val = i;
            boolean ok = true;
            
            for(int j = 0; j < n; j++) {
                val *= 2;
                if(val < a[j] || val > b[j]) {
                    ok = false;
                    break;
                }
            }

            if(ok) {
                System.out.println(i);
                return;
            }
        }
    }
}