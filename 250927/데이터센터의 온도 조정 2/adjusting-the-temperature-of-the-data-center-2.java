import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int g = sc.nextInt();
        int h = sc.nextInt();
        int[] ta = new int[n];
        int[] tb = new int[n];
        int maxT = Integer.MIN_VALUE;
        int minT = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ta[i] = sc.nextInt();
            tb[i] = sc.nextInt();
            
            maxT = Math.max(maxT, ta[i]);
            minT = Math.min(minT, tb[i]);
        }
        // Please write your code here.
        int ans = 0;
        for(int i = minT; i < maxT; i++) {
            int total = 0;
            for(int j = 0; j < n; j++) {
                if(i < ta[j]) total += c;
                else if(ta[j] <= i && i <= tb[j]) total += g;
                else total += h;
            }
            ans = Math.max(ans, total);
        }

        System.out.println(ans);
    }
}