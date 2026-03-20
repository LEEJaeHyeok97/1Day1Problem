import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] memo = new int[1001];

        memo[1] = 2;
        memo[2] = 7;
        for(int i = 3; i <= n; i++) {
            memo[i] = (memo[i-1] * 2) + (memo[i-2] * 4);
        }

        System.out.println(memo[n]);
    }
}