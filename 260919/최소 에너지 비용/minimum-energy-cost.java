import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dist = new int[n + 1];
        int[] cost = new int[n + 1];
        for (int i = 2; i <= n; i++)
            dist[i] = sc.nextInt();
        for (int i = 1; i <= n; i++)
            cost[i] = sc.nextInt();

        long minCost = cost[1];
        long ans = 0;
        for(int i = 1; i <= n-1; i++) {
            minCost = Math.min(minCost, cost[i]);
            ans += (minCost * dist[i+1]);
        }

        System.out.println(ans);
    }
}