import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> t = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            t.add(arr[i]);
        }
            
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
            if(t.ceiling(queries[i]) == null) {
                System.out.println(-1);
                continue;
            }
            System.out.println(t.ceiling(queries[i]));
        }
    }
}