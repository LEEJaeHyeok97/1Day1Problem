import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        TreeSet<Integer> s = new TreeSet<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            s.add(num);
        }

        long ans = Long.MAX_VALUE;
        for(int x : s) {
            Integer c = s.ceiling(x + m);
            if(c != null) {
                ans = Math.min(ans,(long) c - x);
            }
        }

        System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
    }
}