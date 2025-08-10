import java.io.*;
import java.util.*;

public class Main {

    public static TreeMap<Integer, Integer> m = new TreeMap<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                int k = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                m.put(k, v);
            } else if (command.equals("find")) {
                int k = Integer.parseInt(st.nextToken());
                if (m.containsKey(k)) {
                    System.out.println(m.get(k));
                } else {
                    System.out.println("None");
                }
            } else if (command.equals("print_list")) {
                if (m.size() > 0) {
                    for (int key : m.keySet()) {
                        System.out.print(m.get(key) + " ");
                    }
                } else {
                    System.out.println("None");
                }
                System.out.println();
            } else if (command.equals("remove")) {
                int k = Integer.parseInt(st.nextToken());
                m.remove(k);
            }
        }
    }
}
