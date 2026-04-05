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
        memo[3] = 5;
        memo[4] = 11;

        if(n <= 4) {
            System.out.println(memo[n]);
            System.exit(0);
        }

        for(int i = 5; i <= n; i++) {
            memo[i] = memo[i - 2] * 3 + memo[i - 1] - memo[i - 2];
        }
        
        System.out.println(memo[n]);
    }
}