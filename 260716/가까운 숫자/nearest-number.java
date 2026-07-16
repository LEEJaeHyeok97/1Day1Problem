import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> s = new TreeSet<>();
        s.add(0);
        int[] queries = new int[n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            queries[i] = sc.nextInt();
            s.add(queries[i]);
            int l;
            int r;

            if(s.lower(queries[i]) != null) {
                l = queries[i] - s.lower(queries[i]);
                ans = Math.min(ans, l);
            }
            if(s.higher(queries[i]) != null) {
                r = s.higher(queries[i]) - queries[i];
                ans = Math.min(ans, r);
            } 

            System.out.println(ans);
        }
    }
}