import java.util.Scanner;
public class Main {
    
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        memo = new int[n + 1];
        for(int i = 0; i < n + 1; i++) {
            memo[i] = -1;
        }

        int ans = fibo(n);

        System.out.println(ans);
    }

    static int fibo(int n) {
        if(memo[n] != -1) {
            return memo[n];
        }
        if(n <= 2) {
            memo[n] = 1;
        }
        else {
            memo[n] = fibo(n-2) + fibo(n-1);
        }

        return memo[n];
    }
}