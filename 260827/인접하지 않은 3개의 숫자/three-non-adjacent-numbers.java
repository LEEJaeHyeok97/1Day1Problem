import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    public static int[] arr = new int[MAX_N];
    
    public static int[] L = new int[MAX_N];
    public static int[] R = new int[MAX_N];
    public static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        L[0] = arr[0];
        for(int i = 1; i < n; i++) {
            L[i] = Math.max(L[i-1], arr[i]);
        }
        
        R[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--) {
            R[i] = Math.max(R[i+1], arr[i]);
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 2; i < n - 2; i++) {
            ans = Math.max(ans, arr[i] + L[i - 2] + R[i + 2]);
        }

        System.out.println(ans);
    }
}