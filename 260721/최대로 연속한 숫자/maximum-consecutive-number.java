import java.util.*;
import java.io.*;

class Tuple implements Comparable<Tuple> {
    int len, s, e;

    public Tuple(int len, int s, int e) {
        this.len = len;
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Tuple t) {
        if(this.len != t.len)
            return t.len - this.len;
        else if(this.s != t.s)
            return this.s - t.s;
        else
            return this.e - t.e;
    }
}

public class Main {
    static int n, m;
    static TreeSet<Integer> sNum = new TreeSet<>();
    static TreeSet<Tuple> sLen = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sNum.add(-1);
        sNum.add(n + 1);

        sLen.add(new Tuple(n + 1, -1, n + 1));

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int y = Integer.parseInt(st.nextToken());

            sNum.add(y);

            int z = sNum.higher(y);
            int x = sNum.lower(y);

            sLen.remove(new Tuple(z - x - 1, x, z));
            sLen.add(new Tuple(y - x - 1, x, y));
            sLen.add(new Tuple(z - y - 1, y, z));

            System.out.println(sLen.first().len);
        }
    }
}