import java.util.*;

// n개의 수로 이루어진 수열 m개의 질의가 주어진다.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeSet<Integer> s = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            s.add(tmp);
        }

        for (int i = 0; i < m; i++) {
            int query = sc.nextInt();

            if(s.floor(query) != null) {
                System.out.println(s.floor(query));
                s.remove(s.floor(query));
            } else {
                System.out.println(-1);
            }
        }
    }
}