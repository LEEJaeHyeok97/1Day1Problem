import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }

        Arrays.sort(segments, (o1, o2) -> o1[0] - o2[0]);
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = segments[i][1];
        }

        int[] prefixMax = new int[n];
        prefixMax[0] = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], a[i-1]);
        }

        int[] suffixMin = new int[n];
        suffixMin[n-1] = Integer.MAX_VALUE;
        for(int i = n-2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i+1], a[i+1]);
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(prefixMax[i] < a[i] && suffixMin[i] > a[i]) ans++;
        }

        System.out.println(ans);
    }
}