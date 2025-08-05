import java.util.*;
import java.io.*;

public class Main {
    // N개의 문자열
    public static String[] li;
    public static HashMap<String, Integer> dict = new HashMap<>();
    public static int N;
    public static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        li = new String[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            li[i] = s;
            dict.put(s, i);
        }

//        System.out.println("li = " + Arrays.deepToString(li));
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (Character.isDigit(s.charAt(0))) {
                System.out.println(li[Integer.parseInt(s) - 1]);
            } else {
                System.out.println(dict.get(s) + 1);
            }
        }

    }
}