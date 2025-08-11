import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static HashSet<Long> s = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            Long number = Long.parseLong(st.nextToken());

            if (command.equals("find")) {
                if (s.contains(number)) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }

            if (command.equals("add")) {
                s.add(number);
            }

            if (command.equals("remove")) {
                s.remove(number);
            }
        }
    }
}
