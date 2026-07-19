import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair> {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if(this.x != p.x) {
            return Integer.compare(this.x, p.x);
        }
        return Integer.compare(this.y, p.y);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        TreeSet<Pair> s = new TreeSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            s.add(new Pair(x, y));
        }

        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            Pair p = s.ceiling(new Pair(num, 0));
            if(p != null) {
                System.out.println(p.x + " " + p.y);
                s.remove(p);
            } else {
                System.out.println("-1 -1");
            }
        }
    }
}