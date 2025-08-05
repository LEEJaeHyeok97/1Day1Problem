
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            if (command.equals("add")) {
                m.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            if (command.equals("remove")) {
                m.remove(Integer.parseInt(st.nextToken()));
            }

            if (command.equals("find")) {
                int value = Integer.parseInt(st.nextToken());
                if (!m.containsKey(value)) {
                    System.out.println("None");
                } else {
                    System.out.println(m.get(value));
                }
            }
        }
    }
}
