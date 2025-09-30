import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please write your code here.
        int ans = Integer.MAX_VALUE;
        for(int i = 2; i <=100; i+=2) {
            for(int j = 2; j <= 100; j+=2) {
                int site1 = 0;
                int site2 = 0;
                int site3 = 0;
                int site4 = 0;
                for(int k = 0; k < n; k++) {
                    if(x[k] > j && y[k] > i) site1++;
                    if(x[k] < j && y[k] > i) site2++;
                    if(x[k] < j && y[k] < i) site3++;
                    if(x[k] > j && y[k] < i) site4++;
                }

                // System.out.println(site1 + " " + site2 + " " + site3 + " " + site4);

                int maxValue = Math.max(site1, Math.max(site2, Math.max(site3, site4)));
                ans = Math.min(ans, maxValue);
            }
        }
        
        System.out.println(ans);
    }
}