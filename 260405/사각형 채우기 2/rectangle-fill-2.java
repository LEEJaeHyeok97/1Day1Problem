import java.util.*;

public class Main {

    static int[] memo = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i <= n; i++) {
            memo[i] = 0;
        }

        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 3;
        for(int i = 3; i <= n; i++) {
            memo[i] = (memo[i-1] + 2*memo[i-2]) % 10007;
        }
        
        System.out.println(memo[n]);
    }
}